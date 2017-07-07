package xyz.homapay.hampay.core.servermock.transformer;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sima on 11/9/15.
 */
public class InputStreamToByteArrayTransformer  extends AbstractTransformer {

    @Override
    protected Object doTransform(Object o, String s) throws TransformerException {
        if(o instanceof InputStream){
            byte[] buffer = new byte[8192];
            int bytesRead;
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            try {
                while ((bytesRead = ((InputStream)o).read(buffer)) != -1)
                {
                    output.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return output.toByteArray();
        }
        return null;
    }
}
