package xyz.homapay.hampay.core.server.dao.impl;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import xyz.homapay.hampay.core.common.comparator.TACDateComparator;
import xyz.homapay.hampay.core.server.dao.TACDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by sima on 10/26/15.
 * sima.ahmadvand@gmail.com
 */
public class TACDaoImpl implements TACDao {

    public InputStream getTACFileLatestVersion() throws FileNotFoundException {

        GridFS gridfs;
        try {
            gridfs = new GridFS(DbConnection.datastore().getDB());
            List<GridFSDBFile> fsdbFileList = gridfs.find("tac.txt");
            if (fsdbFileList.size() != 0)
                return getLatestTacFile(fsdbFileList).getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new FileNotFoundException();
    }

    private GridFSDBFile getLatestTacFile(List<GridFSDBFile> fsdbFileList) {
        if (fsdbFileList.size() != 0 && fsdbFileList.size() == 1)
            return fsdbFileList.get(0);
        else
            Collections.max(fsdbFileList, new TACDateComparator());
        return fsdbFileList.get(0);
    }

    public Date getTACFileLatestUploadDate() throws FileNotFoundException {
        GridFS gridfs;
        try {
            gridfs = new GridFS(DbConnection.datastore().getDB());
            List<GridFSDBFile> fsdbFileList = gridfs.find("tac.txt");
            if (fsdbFileList.size() != 0)
                return getLatestTacFile(fsdbFileList).getUploadDate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new FileNotFoundException();
    }

}
