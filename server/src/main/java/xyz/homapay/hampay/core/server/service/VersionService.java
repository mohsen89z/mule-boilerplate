package xyz.homapay.hampay.core.server.service;

import xyz.homapay.hampay.core.common.data.model.Version;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.VersionNotFoundException;
import xyz.homapay.hampay.core.server.dao.VersionDao;

import java.util.List;

/**
 * Created by sima on 9/27/15.
 * sima.ahmadvand@gmail.com
 */
public class VersionService {

    private VersionDao versionDao;

    public void setVersionDao(VersionDao versionDao) {
        this.versionDao = versionDao;
    }

    public List<Version> findNotAppliedCurrentVersions() throws DatabaseException, VersionNotFoundException {
        return versionDao.findNotAppliedCurrentVersions();
    }

    public Version findNotAppliedCurrentAndroidVersion() throws DatabaseException, VersionNotFoundException {
        return versionDao.findNotAppliedCurrentAndroidVersion();
    }

    public void update(Version version) throws DatabaseException {
        versionDao.update(version);
    }

    public void updateVersionToApplied(Version version) throws DatabaseException {
        version.setApplied(true);
        versionDao.update(version);
    }

    public void updateVersionToNotApplied(Version version) throws DatabaseException {
        version.setApplied(false);
        versionDao.update(version);
    }
}
