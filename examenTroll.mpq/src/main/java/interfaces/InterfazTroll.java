package interfaces;

import java.io.File;

import excepciones.NoEsImagenException;

public interface InterfazTroll {
    public void recorridoTroll(File rutaInicial);
    public void trastocarImagen(File rutaInicial) throws NoEsImagenException;
}
