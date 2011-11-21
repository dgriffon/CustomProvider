package org.jahia.modules.rssstore.providers;

import org.apache.jackrabbit.value.ValueFactoryImpl;
import org.jahia.modules.providers.ExternalProviderAbstractPropertyImpl;
import org.jahia.modules.providers.ExternalProviderItemImpl;

import javax.jcr.*;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.PropertyDefinition;
import javax.jcr.version.VersionException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: David
 * Date: 10/11/11
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public class RSSProviderPropertyImpl extends ExternalProviderAbstractPropertyImpl {
    private final Object value;
    private final String name;
    private final RSSProviderNodeImpl node;

    public RSSProviderPropertyImpl(RSSProviderNodeImpl node, String name, Object value) {
        this.value = value;
        this.node = node;
        this.name = name;
    }

    @Override
    public Value getValue() throws ValueFormatException, RepositoryException {
        if (value instanceof Date) {
            return ValueFactoryImpl.getInstance().createValue(getDate());
        } else {
            return ValueFactoryImpl.getInstance().createValue(getString());
        }
    }

    @Override
    public Value[] getValues() throws ValueFormatException, RepositoryException {
        return new Value[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getString() throws ValueFormatException, RepositoryException {
        return value.toString();
    }

    @Override
    public InputStream getStream() throws ValueFormatException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Binary getBinary() throws ValueFormatException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getLong() throws ValueFormatException, RepositoryException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getDouble() throws ValueFormatException, RepositoryException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BigDecimal getDecimal() throws ValueFormatException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Calendar getDate() throws ValueFormatException, RepositoryException {
        Calendar instance = Calendar.getInstance();
        instance.setTime((Date) value);
        return instance;
    }

    @Override
    public boolean getBoolean() throws ValueFormatException, RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Node getNode() throws ItemNotFoundException, ValueFormatException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Property getProperty() throws ItemNotFoundException, ValueFormatException, RepositoryException {
        return this;
    }

    @Override
    public long getLength() throws ValueFormatException, RepositoryException {
        return 0;
    }

    @Override
    public long[] getLengths() throws ValueFormatException, RepositoryException {
        return new long[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyDefinition getDefinition() throws RepositoryException {
        return node.getExtendedPrimaryNodeType().getPropertyDefinition(name);
    }

    @Override
    public int getType() throws RepositoryException {
        if (value instanceof Date) {
            return PropertyType.DATE;
        }
        return PropertyType.STRING;
    }

    @Override
    public boolean isMultiple() throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() throws RepositoryException {
        return name;
    }

    @Override
    public boolean isNode() {
        return false;
    }
}
