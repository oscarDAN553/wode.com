package wode.com.api.barcode;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "barcodes")
@Entity(name = "Barcode")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Barcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProducto;
    private String barcode;
    private String activo;

    public Barcode(DTORegistrarBarcode dtoRegistrarBarcode) {
        this.idProducto = dtoRegistrarBarcode.idProducto();
        this.barcode = dtoRegistrarBarcode.barcode();
        this.activo = "1";
    }
}
