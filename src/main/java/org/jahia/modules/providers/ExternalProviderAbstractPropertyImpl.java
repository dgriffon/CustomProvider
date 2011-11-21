/**
 *
 * This file is part of Jahia: An integrated WCM, DMS and Portal Solution
 * Copyright (C) 2002-2009 Jahia Limited. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 * As a special exception to the terms and conditions of version 2.0 of
 * the GPL (or any later version), you may redistribute this Program in connection
 * with Free/Libre and Open Source Software ("FLOSS") applications as described
 * in Jahia's FLOSS exception. You should have recieved a copy of the text
 * describing the FLOSS exception, and it is also available here:
 * http://www.jahia.com/license"
 *
 * Commercial and Supported Versions of the program
 * Alternatively, commercial and supported versions of the program may be used
 * in accordance with the terms contained in a separate written agreement
 * between you and Jahia Limited. If you are unsure which license is appropriate
 * for your use, please contact the sales department at sales@jahia.com.
 */
package org.jahia.modules.providers;

import org.apache.log4j.Logger;

import javax.jcr.*;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.PropertyDefinition;
import javax.jcr.version.VersionException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : rincevent
 * @since : JAHIA 6.1
 *        Created : 11/21/11
 */
public abstract class ExternalProviderAbstractPropertyImpl extends ExternalProviderItemImpl implements Property {
    private transient static Logger logger = Logger.getLogger(ExternalProviderAbstractPropertyImpl.class);

    public void setValue(Value value)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(Value[] values)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(String value)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(String[] values)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(InputStream value)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(Binary value)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(long value)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(double value)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(BigDecimal value)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(Calendar value)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(boolean value)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setValue(Node value)
            throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public abstract Value getValue() throws ValueFormatException, RepositoryException;

    public abstract Value[] getValues() throws ValueFormatException, RepositoryException;

    public abstract String getString() throws ValueFormatException, RepositoryException;

    public abstract InputStream getStream() throws ValueFormatException, RepositoryException;

    public abstract Binary getBinary() throws ValueFormatException, RepositoryException;

    public abstract long getLong() throws ValueFormatException, RepositoryException;

    public abstract double getDouble() throws ValueFormatException, RepositoryException;

    public abstract BigDecimal getDecimal() throws ValueFormatException, RepositoryException;

    public abstract Calendar getDate() throws ValueFormatException, RepositoryException;

    public abstract boolean getBoolean() throws ValueFormatException, RepositoryException;

    public abstract Node getNode() throws ItemNotFoundException, ValueFormatException, RepositoryException;

    public abstract Property getProperty() throws ItemNotFoundException, ValueFormatException, RepositoryException;

    public abstract long getLength() throws ValueFormatException, RepositoryException;

    public abstract long[] getLengths() throws ValueFormatException, RepositoryException;

    public abstract PropertyDefinition getDefinition() throws RepositoryException;

    public abstract int getType() throws RepositoryException;

    public abstract boolean isMultiple() throws RepositoryException;

    @Override
    public abstract String getName() throws RepositoryException;

    @Override
    public abstract boolean isNode();
}
