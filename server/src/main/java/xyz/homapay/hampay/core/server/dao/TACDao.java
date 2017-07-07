package xyz.homapay.hampay.core.server.dao;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by sima on 10/26/15.
 * sima.ahmadvand@gmail.com
 */
public interface TACDao {

    InputStream getTACFileLatestVersion() throws FileNotFoundException;

    Date getTACFileLatestUploadDate() throws FileNotFoundException;
}
