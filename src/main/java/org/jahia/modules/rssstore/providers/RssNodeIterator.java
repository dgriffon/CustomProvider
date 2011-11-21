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
package org.jahia.modules.rssstore.providers;

import org.apache.log4j.Logger;
import org.jahia.modules.rssstore.camel.RssBean;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : rincevent
 * @since : JAHIA 6.1
 *        Created : 11/18/11
 */
public class RssNodeIterator implements NodeIterator {
    private transient static Logger logger = Logger.getLogger(RssNodeIterator.class);
    private Iterator<Map.Entry<String, RssBean>> rssEntries = null;
    private RssSessionImpl session = null;
    private int size;

    public RssNodeIterator(RssSessionImpl session) {
        if (session != null) {
            this.session = session;
            Set<Map.Entry<String, RssBean>> entries = ((RssRepositoryImpl) session.getRepository()).getRssEntries().entrySet();
            size = entries.size();
            rssEntries = entries.iterator();
        }
    }

    /**
     * Returns the next <code>Node</code> in the iteration.
     *
     * @return the next <code>Node</code> in the iteration.
     * @throws java.util.NoSuchElementException
     *          if iteration has no more
     *          <code>Node</code>s.
     */
    public Node nextNode() {
        return new RSSProviderNodeImpl(session, rssEntries.next().getValue());
    }

    /**
     * Skip a number of elements in the iterator.
     *
     * @param skipNum the non-negative number of elements to skip
     * @throws java.util.NoSuchElementException
     *          if skipped past the last element
     *          in the iterator.
     */
    public void skip(long skipNum) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Returns the total number of of items available through this iterator. For
     * example, for some node <code>N</code>, <code>N.getNodes().getSize()</code>
     * returns the number of child nodes of <code>N</code> visible through the
     * current <code>Session</code>. In some implementations precise information
     * about the number of elements may not be available. In such cases this
     * method must return -1. API clients will then be able to use
     * <code>RangeIterator.getNumberRemaining</code> to get an estimate on the
     * number of elements.
     *
     * @return a long
     */
    public long getSize() {
        return size;
    }

    /**
     * Returns the current position within the iterator. The number returned is
     * the 0-based index of the next element in the iterator, i.e. the one that
     * will be returned on the subsequent <code>next</code> call.
     * <p/>
     * Note that this method does not check if there is a next element, i.e. an
     * empty iterator will always return 0.
     *
     * @return a long
     */
    public long getPosition() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Returns <tt>true</tt> if the iteration has more elements. (In other
     * words, returns <tt>true</tt> if <tt>next</tt> would return an element
     * rather than throwing an exception.)
     *
     * @return <tt>true</tt> if the iterator has more elements.
     */
    public boolean hasNext() {
        return rssEntries != null && rssEntries.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration.
     * @throws java.util.NoSuchElementException
     *          iteration has no more elements.
     */
    public Object next() {
        return nextNode();
    }

    /**
     * Removes from the underlying collection the last element returned by the
     * iterator (optional operation).  This method can be called only once per
     * call to <tt>next</tt>.  The behavior of an iterator is unspecified if
     * the underlying collection is modified while the iteration is in
     * progress in any way other than by calling this method.
     *
     * @throws UnsupportedOperationException if the <tt>remove</tt>
     *                                       operation is not supported by this Iterator.
     * @throws IllegalStateException         if the <tt>next</tt> method has not
     *                                       yet been called, or the <tt>remove</tt> method has already
     *                                       been called after the last call to the <tt>next</tt>
     *                                       method.
     */
    public void remove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
