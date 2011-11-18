package org.jahia.modules.rssstore.providers;


import javax.jcr.*;
import java.util.*;
import org.jahia.services.content.nodetypes.ValueImpl;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 11/9/11
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class RssRepositoryImpl implements Repository{

    private Map<String, Object> repositoryDescriptors = new HashMap<String, Object>();
    private String root;

    private static final Set<String> STANDARD_KEYS = new HashSet<String>() {{
        add(Repository.QUERY_FULL_TEXT_SEARCH_SUPPORTED);
        add(Repository.QUERY_JOINS);
        add(Repository.QUERY_LANGUAGES);
        add(Repository.QUERY_STORED_QUERIES_SUPPORTED);
        add(Repository.QUERY_XPATH_DOC_ORDER);
        add(Repository.QUERY_XPATH_POS_INDEX);
        add(Repository.REP_NAME_DESC);
        add(Repository.REP_VENDOR_DESC);
        add(Repository.REP_VENDOR_URL_DESC);
        add(Repository.SPEC_NAME_DESC);
        add(Repository.SPEC_VERSION_DESC);
        add(Repository.WRITE_SUPPORTED);
        add(Repository.IDENTIFIER_STABILITY);
        add(Repository.LEVEL_1_SUPPORTED);
        add(Repository.LEVEL_2_SUPPORTED);

        add(Repository.OPTION_NODE_TYPE_MANAGEMENT_SUPPORTED);
        add(Repository.NODE_TYPE_MANAGEMENT_AUTOCREATED_DEFINITIONS_SUPPORTED);
        add(Repository.NODE_TYPE_MANAGEMENT_INHERITANCE);
        add(Repository.NODE_TYPE_MANAGEMENT_MULTIPLE_BINARY_PROPERTIES_SUPPORTED);
        add(Repository.NODE_TYPE_MANAGEMENT_MULTIVALUED_PROPERTIES_SUPPORTED);
        add(Repository.NODE_TYPE_MANAGEMENT_ORDERABLE_CHILD_NODES_SUPPORTED);
        add(Repository.NODE_TYPE_MANAGEMENT_OVERRIDES_SUPPORTED);
        add(Repository.NODE_TYPE_MANAGEMENT_PRIMARY_ITEM_NAME_SUPPORTED);
        add(Repository.NODE_TYPE_MANAGEMENT_PROPERTY_TYPES);
        add(Repository.NODE_TYPE_MANAGEMENT_RESIDUAL_DEFINITIONS_SUPPORTED);
        add(Repository.NODE_TYPE_MANAGEMENT_SAME_NAME_SIBLINGS_SUPPORTED);
        add(Repository.NODE_TYPE_MANAGEMENT_VALUE_CONSTRAINTS_SUPPORTED);
        add(Repository.NODE_TYPE_MANAGEMENT_UPDATE_IN_USE_SUPORTED);
        add(Repository.OPTION_ACCESS_CONTROL_SUPPORTED);
        add(Repository.OPTION_JOURNALED_OBSERVATION_SUPPORTED);
        add(Repository.OPTION_LIFECYCLE_SUPPORTED);
        add(Repository.OPTION_LOCKING_SUPPORTED);
        add(Repository.OPTION_OBSERVATION_SUPPORTED);
        add(Repository.OPTION_NODE_AND_PROPERTY_WITH_SAME_NAME_SUPPORTED);
        add(Repository.OPTION_QUERY_SQL_SUPPORTED);
        add(Repository.OPTION_RETENTION_SUPPORTED);
        add(Repository.OPTION_SHAREABLE_NODES_SUPPORTED);
        add(Repository.OPTION_SIMPLE_VERSIONING_SUPPORTED);
        add(Repository.OPTION_TRANSACTIONS_SUPPORTED);
        add(Repository.OPTION_UNFILED_CONTENT_SUPPORTED);
        add(Repository.OPTION_UPDATE_MIXIN_NODE_TYPES_SUPPORTED);
        add(Repository.OPTION_UPDATE_PRIMARY_NODE_TYPE_SUPPORTED);
        add(Repository.OPTION_VERSIONING_SUPPORTED);
        add(Repository.OPTION_WORKSPACE_MANAGEMENT_SUPPORTED);
        add(Repository.OPTION_XML_EXPORT_SUPPORTED);
        add(Repository.OPTION_XML_IMPORT_SUPPORTED);
        add(Repository.OPTION_ACTIVITIES_SUPPORTED);
        add(Repository.OPTION_BASELINES_SUPPORTED);

    }};

    private void initDescriptors() {

        repositoryDescriptors.put(Repository.SPEC_VERSION_DESC, new ValueImpl("2.0",PropertyType.STRING));
        repositoryDescriptors.put(Repository.SPEC_NAME_DESC, new ValueImpl("Content Repository for Java Technology API",PropertyType.STRING));
        repositoryDescriptors.put(Repository.REP_VENDOR_DESC, new ValueImpl("Jahia",PropertyType.STRING));
        repositoryDescriptors.put(Repository.REP_VENDOR_URL_DESC, new ValueImpl("http://www.jahia.org",PropertyType.STRING));
        repositoryDescriptors.put(Repository.REP_NAME_DESC, new ValueImpl("The Web Integration Software",PropertyType.STRING));
        repositoryDescriptors.put(Repository.REP_VERSION_DESC, new ValueImpl("1.0",PropertyType.STRING));
        repositoryDescriptors.put(Repository.WRITE_SUPPORTED, new ValueImpl(true));
        repositoryDescriptors.put(Repository.IDENTIFIER_STABILITY, new ValueImpl(Repository.IDENTIFIER_STABILITY_SESSION_DURATION,PropertyType.STRING));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_INHERITANCE, new ValueImpl(Repository.NODE_TYPE_MANAGEMENT_INHERITANCE_MINIMAL,PropertyType.STRING));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_OVERRIDES_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_PRIMARY_ITEM_NAME_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_ORDERABLE_CHILD_NODES_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_RESIDUAL_DEFINITIONS_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_AUTOCREATED_DEFINITIONS_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_SAME_NAME_SIBLINGS_SUPPORTED, new ValueImpl(false));
        List<ValueImpl> propertyTypes = new ArrayList<ValueImpl>();
        propertyTypes.add(new ValueImpl(PropertyType.BINARY));
        propertyTypes.add(new ValueImpl(PropertyType.NAME));
        propertyTypes.add(new ValueImpl(PropertyType.PATH));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_PROPERTY_TYPES, propertyTypes.toArray(new ValueImpl[propertyTypes.size()]));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_MULTIVALUED_PROPERTIES_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_MULTIPLE_BINARY_PROPERTIES_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_VALUE_CONSTRAINTS_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.NODE_TYPE_MANAGEMENT_UPDATE_IN_USE_SUPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.QUERY_LANGUAGES, new ValueImpl[0]);
        repositoryDescriptors.put(Repository.QUERY_STORED_QUERIES_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.QUERY_FULL_TEXT_SEARCH_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.QUERY_JOINS, new ValueImpl(false));
        repositoryDescriptors.put(Repository.LEVEL_1_SUPPORTED, new ValueImpl(true));
        repositoryDescriptors.put(Repository.LEVEL_2_SUPPORTED, new ValueImpl(true));
        repositoryDescriptors.put(Repository.QUERY_XPATH_POS_INDEX, new ValueImpl(false));
        repositoryDescriptors.put(Repository.QUERY_XPATH_DOC_ORDER, new ValueImpl(false));

        repositoryDescriptors.put(Repository.OPTION_ACCESS_CONTROL_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_ACTIVITIES_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_BASELINES_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_JOURNALED_OBSERVATION_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_LIFECYCLE_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_LOCKING_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_NODE_AND_PROPERTY_WITH_SAME_NAME_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_NODE_TYPE_MANAGEMENT_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_OBSERVATION_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_QUERY_SQL_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_RETENTION_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_SHAREABLE_NODES_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_SIMPLE_VERSIONING_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_TRANSACTIONS_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_UNFILED_CONTENT_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_UPDATE_MIXIN_NODE_TYPES_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_UPDATE_PRIMARY_NODE_TYPE_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_VERSIONING_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_WORKSPACE_MANAGEMENT_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_XML_EXPORT_SUPPORTED, new ValueImpl(false));
        repositoryDescriptors.put(Repository.OPTION_XML_IMPORT_SUPPORTED, new ValueImpl(false));
    }
    
    public RssRepositoryImpl(String root) {
        this.root = root;
        initDescriptors();
    }

    public String[] getDescriptorKeys() {
        return repositoryDescriptors.keySet().toArray(new String[repositoryDescriptors.size()]);
    }

    public boolean isStandardDescriptor(String key) {
        return STANDARD_KEYS.contains(key);
    }

    public boolean isSingleValueDescriptor(String key) {
        Object repositoryDescriptor = repositoryDescriptors.get(key);
        if (repositoryDescriptor instanceof Value) {
            return true;
        } else {
            return false;
        }
    }

    public Value getDescriptorValue(String key) {
        return (Value) repositoryDescriptors.get(key);
    }

    public Value[] getDescriptorValues(String key) {
        return (Value[]) repositoryDescriptors.get(key);
    }

    public String getDescriptor(String key) {
        Object descriptorObject = repositoryDescriptors.get(key);
        if (descriptorObject == null) {
            return null;
        }
        if (descriptorObject instanceof Value) {
            return ((Value) descriptorObject).toString();
        } else {
            throw new RuntimeException("Expected single-value value but found multi-valued property instead !");
        }
    }

    public Session login(Credentials credentials, String workspaceName) throws LoginException, NoSuchWorkspaceException, RepositoryException {
        return login();
    }

    public Session login(Credentials credentials) throws LoginException, RepositoryException {
        return login();
    }

    public Session login(String workspaceName) throws LoginException, NoSuchWorkspaceException, RepositoryException {
        return login();
    }

    public Session login() throws LoginException, RepositoryException {
        return new RssSessionImpl(this);
    }

    public String getRoot() {
        return root;
    }
}
