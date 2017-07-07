package xyz.homapay.hampay.core.server.dao.impl;

import xyz.homapay.hampay.core.common.data.model.OSName;
import xyz.homapay.hampay.core.common.data.model.Version;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.VersionNotFoundException;
import xyz.homapay.hampay.core.server.dao.VersionDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.List;

/**
 * Created by sima on 9/27/15.
 * sima.ahmadvand@gmail.com
 */
public class VersionDaoImpl implements VersionDao {

    @Override
    public List<Version> findNotAppliedCurrentVersions() throws DatabaseException, VersionNotFoundException {
        List<Version> versions;
        try {
            versions = DbConnection.datastore().find(Version.class).field("applied").equal(false).field("current").equal(true).asList();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }
        if (versions == null || versions.size() == 0)
            throw new VersionNotFoundException();
        return versions;

    }

    @Override
    public Version findNotAppliedCurrentAndroidVersion() throws DatabaseException, VersionNotFoundException {
        Version version;
        try {
            version = DbConnection.datastore().find(Version.class).field("applied").equal(false).field("os").equal(OSName.ANDROID)
                    .field("current").equal(true).get();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }
        if (version == null)
            throw new VersionNotFoundException();
        return version;
    }

    @Override
    public void update(Version version) throws DatabaseException {
        try {
            DbConnection.datastore().save(version);
        } catch (IOException e) {
            throw new DatabaseException();
        }
    }
}
