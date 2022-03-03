package s_seguimiento_pacientes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Luis Romero - Santiago Cordoba
 */
public class UtilidadesObjectOutputStream extends ObjectOutputStream {

    public UtilidadesObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    public UtilidadesObjectOutputStream() throws IOException, SecurityException {
        super();
    }

    protected void writeStreamHeader() throws IOException {

    }
}
