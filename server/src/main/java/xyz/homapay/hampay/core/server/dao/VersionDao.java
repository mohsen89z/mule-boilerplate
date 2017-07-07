package xyz.homapay.hampay.core.server.dao;

import xyz.homapay.hampay.core.common.data.model.Version;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.VersionNotFoundException;

import java.util.List;

/**
 * Created by sima on 9/27/15.
 * sima.ahmadvand@gmail.com
 */
public interface VersionDao {

    List<Version> findNotAppliedCurrentVersions() throws DatabaseException, VersionNotFoundException;

    Version findNotAppliedCurrentAndroidVersion() throws DatabaseException, VersionNotFoundException;

    void update(Version version) throws DatabaseException;
}
