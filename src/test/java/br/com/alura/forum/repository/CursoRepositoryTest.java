package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CursoRepositoryTest {
    @Autowired
    private CursoRepository cursoRepository;

    @Test
    public void pegarCursoPeloNome(){
        String nome = "HTML 5";
        Curso curso = cursoRepository.findByNome(nome);

        Assert.assertNotNull(curso);
        Assert.assertEquals(nome, curso.getNome());
    }


    @Test
    public void cursoNaoExiste(){
        String nome = "JPA";
        Curso curso = cursoRepository.findByNome(nome);

        Assert.assertNull(curso);
    }

}