package xyz.homapay.hampay.core.common.comparator;

import com.mongodb.gridfs.GridFSDBFile;

import java.util.Comparator;

/**
 * Created by sima on 7/2/15.
 */
public class TACDateComparator implements Comparator<GridFSDBFile> {

    @Override
    public int compare(GridFSDBFile gridFSDBFile1, GridFSDBFile gridFSDBFile2) {
        return gridFSDBFile1.getUploadDate().compareTo(gridFSDBFile2.getUploadDate());
    }
}
