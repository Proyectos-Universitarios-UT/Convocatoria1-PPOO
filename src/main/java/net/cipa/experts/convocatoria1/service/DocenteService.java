package net.cipa.experts.convocatoria1.service;

import net.cipa.experts.convocatoria1.model.Docente;
import net.cipa.experts.convocatoria1.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {
    @Autowired
    private DocenteRepository docenteRepository;
    public Docente guardar(Docente docente){
        return docenteRepository.save(docente);
    }

    public List<Docente> listarDocentes(){
        return (List<Docente>) docenteRepository.findAll();
    }

    public Optional<Docente> buscarPorId(Long id){
        return docenteRepository.findById(id);
    }

    public Docente actualizarDocente(@RequestBody Docente docente){
        if (docenteRepository.existsById(docente.getId())){
            return docenteRepository.save(docente);
        }
        return null;
    }

    public void eliminarDocente(@PathVariable Long id){
        if (docenteRepository.existsById(id)){
            docenteRepository.deleteById(id);
        }
    }

}
