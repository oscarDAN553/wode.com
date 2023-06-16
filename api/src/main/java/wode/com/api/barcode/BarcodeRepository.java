package wode.com.api.barcode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BarcodeRepository extends JpaRepository<Barcode, Long> {
    @Query("SELECT b FROM Barcode b WHERE b.id = :id")
    Barcode findByIdContaining(Long id);
}
