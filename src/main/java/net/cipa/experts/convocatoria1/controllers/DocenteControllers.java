package net.cipa.experts.convocatoria1.controllers;

import net.cipa.experts.convocatoria1.model.Docente;
import net.cipa.experts.convocatoria1.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class DocenteControllers {
    @Autowired
    private DocenteService docenteService;

    @PostMapping("/docente")
    public ResponseEntity<Docente> guardar(@RequestBody Docente docente){
        return ResponseEntity.ok(docenteService.guardar(docente));
    }

    @GetMapping("/docentes")
    public ResponseEntity<List<Docente>> todosLosDocentes(){
        return ResponseEntity.ok(docenteService.listarDocentes());
    }

    @GetMapping("/docente/{id}")
    public ResponseEntity<Optional<Docente>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(docenteService.buscarPorId(id));
    }

    @PatchMapping("/docente")
    public ResponseEntity<Docente> actualizar(@RequestBody Docente docente){
        return ResponseEntity.ok(docenteService.actualizarDocente(docente));
    }

    @DeleteMapping("/docente/{id}")
    public void borrarDocente(@PathVariable Long id){
        docenteService.eliminarDocente(id);
        ResponseEntity.ok();
    }
}
