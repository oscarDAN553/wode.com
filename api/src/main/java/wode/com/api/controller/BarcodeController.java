package wode.com.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
