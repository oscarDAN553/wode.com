package wode.com.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wode.com.api.barcode.Barcode;
import wode.com.api.barcode.BarcodeRepository;
import wode.com.api.barcode.DTORegistrarBarcode;

@RestController
@RequestMapping("/barcode")
public class BarcodeController {
    @Autowired
    private BarcodeRepository barcodeRepository;
    @PostMapping
    public void registrarBarcode (@RequestBody @Valid DTORegistrarBarcode dtoRegistrarBarcode){
           barcodeRepository.save(new Barcode(dtoRegistrarBarcode));
    }
    @DeleteMapping
    @Transactional
    public ResponseEntity<Barcode> DesactivarBarcode(@RequestParam("id") Long id){
         Barcode codigo = barcodeRepository.findByIdContaining(id);
         codigo.desactivarBarcode();
         return null;
    }
}
