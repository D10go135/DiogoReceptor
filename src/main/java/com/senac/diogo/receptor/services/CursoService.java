package com.senac.diogo.receptor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.diogo.receptor.dtos.UsuarioDTO;
import com.senac.diogo.receptor.entities.Curso;
import com.senac.diogo.receptor.repositories.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Lista apenas cursos disponíveis (status = 1)
    public List<Curso> listarCursosDisponiveis() {
        return cursoRepository.findByStatus(1);
    }

    public Optional<Curso> listarCursoPorId(int id) {
        return cursoRepository.findById(id);  // Retorna um Optional para evitar null
    }

    public Curso adicionarCurso(Curso curso) {
        curso.setStatus(1); // Define status como ativo ao adicionar

        // Enviar uma mensagem de aviso para a fila RabbitMQ
        rabbitTemplate.convertAndSend("fila-galeria", curso);

        return cursoRepository.save(curso);
    }

    public String apagarCursoLogicamente(int id) {
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso == null) {
            return "Curso não encontrado";
        }
        curso.setStatus(-1); // Define status como apagado
        cursoRepository.save(curso);
        return "Curso apagado logicamente com sucesso!";
    }

    // Atualiza um curso existente
    public Curso atualizarCurso(int id, Curso cursoAtualizado) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);
        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setNomecurso(cursoAtualizado.getNomecurso());
            curso.setMateria(cursoAtualizado.getMateria());
            curso.setDuracao(cursoAtualizado.getDuracao());
            curso.setStatus(cursoAtualizado.getStatus());
            return cursoRepository.save(curso);
        } else {
            return null;  // Ou lançar uma exceção caso preferir
        }
    }

    // Método de recepção de mensagens do RabbitMQ
    @RabbitListener(queues = "usuariocurso")
    private void subscribe(UsuarioDTO usuario) {
        System.out.println("Novo usuário adicionado: " + usuario.getNome() + " " + usuario.getSobrenome() + ", " + usuario.getTelefone());
        // Processar a mensagem de acordo com a necessidade
    }
}
