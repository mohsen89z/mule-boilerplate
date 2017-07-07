package xyz.homapay.hampay.core.test.service;

import org.easymock.EasyMock;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by sima on 6/7/15.
 */
public class EasyMockFactoryBean<T> implements FactoryBean<T> {
    private Class<T> mockedClass;

    public void setMockedClass(Class mockedClass) {
        this.mockedClass = mockedClass;
    }

    public T getObject() throws Exception {
        return EasyMock.createMock(mockedClass);
    }

    public Class<T> getObjectType() {
        return mockedClass;
    }

    public boolean isSingleton() {
        return true;
    }

}