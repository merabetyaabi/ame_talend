package org.talend.designer.codegen.translators.generic.component;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.talend.components.api.component.ComponentDefinition;
import org.talend.designer.core.generic.model.Component;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.TalendTextUtils;

public class ComponentMain
{
  protected static String nl;
  public static synchronized ComponentMain create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentMain result = new ComponentMain();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            boolean ";
  protected final String TEXT_2 = " = false;" + NL + "            routines.system.Dynamic ";
  protected final String TEXT_3 = " = new routines.system.Dynamic();";
  protected final String TEXT_4 = NL + "        org.talend.daikon.di.DiOutgoingSchemaEnforcer ";
  protected final String TEXT_5 = NL + "                = new org.talend.daikon.di.DiOutgoingSchemaEnforcer(";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ");" + NL + "" + NL + "        // Create a reusable factory that converts the output of the reader to an IndexedRecord." + NL + "        org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord> ";
  protected final String TEXT_8 = " = null;";
  protected final String TEXT_9 = NL + "        // Construct the factory once when the first data arrives." + NL + "        if (";
  protected final String TEXT_10 = " == null) {";
  protected final String TEXT_11 = NL + "            ";
  protected final String TEXT_12 = " = (org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord>)" + NL + "                    new org.talend.daikon.avro.AvroRegistry()" + NL + "                            .createIndexedRecordConverter(";
  protected final String TEXT_13 = ".getClass());" + NL + "        }" + NL + "" + NL + "        // Enforce the outgoing schema on the input.";
  protected final String TEXT_14 = NL + "        ";
  protected final String TEXT_15 = ".setWrapped(";
  protected final String TEXT_16 = ".convertToAvro(";
  protected final String TEXT_17 = "));";
  protected final String TEXT_18 = NL + "            if (!";
  protected final String TEXT_19 = ") {" + NL + "                org.apache.avro.Schema dynSchema_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ".getOutgoingDynamicRuntimeSchema();" + NL + "                for (org.apache.avro.Schema.Field childDynamic_";
  protected final String TEXT_22 = " : dynSchema_";
  protected final String TEXT_23 = ".getFields()){" + NL + "                    routines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_24 = " = new routines.system.DynamicMetadata();" + NL + "                    dynamicMetadata_";
  protected final String TEXT_25 = ".setName(childDynamic_";
  protected final String TEXT_26 = ".name());" + NL + "                    dynamicMetadata_";
  protected final String TEXT_27 = ".setDbName(childDynamic_";
  protected final String TEXT_28 = ".name());" + NL + "                    String talendType_";
  protected final String TEXT_29 = " = null;" + NL + "                    org.apache.avro.Schema.Type type_";
  protected final String TEXT_30 = " = childDynamic_";
  protected final String TEXT_31 = ".schema().getType();" + NL + "                    if(type_";
  protected final String TEXT_32 = "  == org.apache.avro.Schema.Type.UNION){" + NL + "                    \tjava.util.List<org.apache.avro.Schema> fieldTypes_";
  protected final String TEXT_33 = " = childDynamic_";
  protected final String TEXT_34 = ".schema().getTypes();" + NL + "                    \tfor(org.apache.avro.Schema fieldType_";
  protected final String TEXT_35 = ":fieldTypes_";
  protected final String TEXT_36 = "){" + NL + "                    \t\tif(fieldType_";
  protected final String TEXT_37 = ".getType() == org.apache.avro.Schema.Type.NULL){" + NL + "                    \t\t\tdynamicMetadata_";
  protected final String TEXT_38 = ".setNullable(true);" + NL + "                    \t\t}else{" + NL + "                    \t\t\ttype_";
  protected final String TEXT_39 = " = fieldType_";
  protected final String TEXT_40 = ".getType();" + NL + "                    \t\t}" + NL + "                    \t}" + NL + "\t\t\t\t\t}" + NL + "                    if (type_";
  protected final String TEXT_41 = " == org.apache.avro.Schema.Type.ARRAY) {" + NL + "                        talendType_";
  protected final String TEXT_42 = " = \"";
  protected final String TEXT_43 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_44 = " == org.apache.avro.Schema.Type.BOOLEAN) {" + NL + "                        talendType_";
  protected final String TEXT_45 = " = \"";
  protected final String TEXT_46 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_47 = " == org.apache.avro.Schema.Type.BYTES) {" + NL + "                        talendType_";
  protected final String TEXT_48 = " = \"";
  protected final String TEXT_49 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_50 = " == org.apache.avro.Schema.Type.FIXED) {" + NL + "                        talendType_";
  protected final String TEXT_51 = " = \"";
  protected final String TEXT_52 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_53 = " == org.apache.avro.Schema.Type.DOUBLE) {" + NL + "                        talendType_";
  protected final String TEXT_54 = " = \"";
  protected final String TEXT_55 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_56 = " == org.apache.avro.Schema.Type.FLOAT) {" + NL + "                        talendType_";
  protected final String TEXT_57 = " = \"";
  protected final String TEXT_58 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_59 = " == org.apache.avro.Schema.Type.INT) {" + NL + "                        talendType_";
  protected final String TEXT_60 = " = \"";
  protected final String TEXT_61 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_62 = " == org.apache.avro.Schema.Type.LONG) {" + NL + "                    \tString pattern_";
  protected final String TEXT_63 = " = childDynamic_";
  protected final String TEXT_64 = ".getProp(org.talend.daikon.di.DiSchemaConstants.TALEND6_COLUMN_PATTERN);" + NL + "                    \tif(pattern_";
  protected final String TEXT_65 = "!=null && !pattern_";
  protected final String TEXT_66 = ".trim().isEmpty()){" + NL + "                    \t\ttalendType_";
  protected final String TEXT_67 = " = \"";
  protected final String TEXT_68 = "\";" + NL + "                    \t\tdynamicMetadata_";
  protected final String TEXT_69 = ".setFormat(pattern_";
  protected final String TEXT_70 = ");" + NL + "                    \t}else{" + NL + "                    \t\ttalendType_";
  protected final String TEXT_71 = " = \"";
  protected final String TEXT_72 = "\";" + NL + "                    \t}" + NL + "                    } else if (type_";
  protected final String TEXT_73 = " == org.apache.avro.Schema.Type.ENUM) {" + NL + "                        talendType_";
  protected final String TEXT_74 = " = \"";
  protected final String TEXT_75 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_76 = " == org.apache.avro.Schema.Type.STRING) {" + NL + "                        talendType_";
  protected final String TEXT_77 = " = \"";
  protected final String TEXT_78 = "\";" + NL + "                    }" + NL + "                    Object length_";
  protected final String TEXT_79 = " = childDynamic_";
  protected final String TEXT_80 = ".getProp(org.talend.daikon.di.DiSchemaConstants.TALEND6_COLUMN_LENGTH);" + NL + "                    if(length_";
  protected final String TEXT_81 = " != null){" + NL + "                    \tdynamicMetadata_";
  protected final String TEXT_82 = ".setLength(Integer.parseInt(String.valueOf(length_";
  protected final String TEXT_83 = ")));" + NL + "                    }" + NL + "                    Object precision_";
  protected final String TEXT_84 = " = childDynamic_";
  protected final String TEXT_85 = ".getProp(org.talend.daikon.di.DiSchemaConstants.TALEND6_COLUMN_PRECISION); " + NL + "                    if(precision_";
  protected final String TEXT_86 = " != null){" + NL + "\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_87 = ".setPrecision(Integer.parseInt(String.valueOf(precision_";
  protected final String TEXT_88 = ")));" + NL + "                    } " + NL + "                    dynamicMetadata_";
  protected final String TEXT_89 = ".setType(talendType_";
  protected final String TEXT_90 = ");";
  protected final String TEXT_91 = NL + "                    ";
  protected final String TEXT_92 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_93 = ");" + NL + "                }" + NL + "                initDyn_";
  protected final String TEXT_94 = " = true;" + NL + "            }";
  protected final String TEXT_95 = NL + "            ";
  protected final String TEXT_96 = ".clearColumnValues();";
  protected final String TEXT_97 = NL + "                java.util.Map<String, Object> dynamicValue_";
  protected final String TEXT_98 = " =" + NL + "                        (java.util.Map<String, Object>) ";
  protected final String TEXT_99 = ".get(";
  protected final String TEXT_100 = ");" + NL + "                for (String dynamicValue_Key_";
  protected final String TEXT_101 = " : ((java.util.Map<String, Object>)";
  protected final String TEXT_102 = ".get(";
  protected final String TEXT_103 = ")).keySet()) {";
  protected final String TEXT_104 = NL + "                    ";
  protected final String TEXT_105 = ".setColumnValue(";
  protected final String TEXT_106 = NL + "                            ";
  protected final String TEXT_107 = ".getIndex(dynamicValue_Key_";
  protected final String TEXT_108 = ")," + NL + "                            dynamicValue_";
  protected final String TEXT_109 = ".get(dynamicValue_Key_";
  protected final String TEXT_110 = "));" + NL + "                }";
  protected final String TEXT_111 = NL + "                ";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " = ";
  protected final String TEXT_114 = ";";
  protected final String TEXT_115 = NL + "                if (";
  protected final String TEXT_116 = ".get(";
  protected final String TEXT_117 = ") == null) {";
  protected final String TEXT_118 = NL + "                     ";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = " = ";
  protected final String TEXT_121 = ";" + NL + "                } else {";
  protected final String TEXT_122 = NL + "                        ";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = " = String.valueOf(";
  protected final String TEXT_125 = ".get(";
  protected final String TEXT_126 = "));";
  protected final String TEXT_127 = NL + "                        ";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = " = (";
  protected final String TEXT_130 = ") (";
  protected final String TEXT_131 = ".get(";
  protected final String TEXT_132 = "));";
  protected final String TEXT_133 = NL + "                }";
  protected final String TEXT_134 = NL + "                ";
  protected final String TEXT_135 = " = null;";
  protected final String TEXT_136 = NL + "                if (current_";
  protected final String TEXT_137 = ".needsInitDynamicColumns()) {" + NL + "                    // Initialize the dynamic columns when they are first encountered." + NL + "                    for (routines.system.DynamicMetadata dm_";
  protected final String TEXT_138 = " : ";
  protected final String TEXT_139 = ".";
  protected final String TEXT_140 = ".metadatas) {" + NL + "                        current_";
  protected final String TEXT_141 = ".initDynamicColumn(" + NL + "                                dm_";
  protected final String TEXT_142 = ".getName(), dm_";
  protected final String TEXT_143 = ".getDbName()," + NL + "                                dm_";
  protected final String TEXT_144 = ".getType(), dm_";
  protected final String TEXT_145 = ".getDbType()," + NL + "                                dm_";
  protected final String TEXT_146 = ".getDbTypeId(), dm_";
  protected final String TEXT_147 = ".getLength()," + NL + "                                dm_";
  protected final String TEXT_148 = ".getPrecision(), dm_";
  protected final String TEXT_149 = ".getFormat()," + NL + "                                dm_";
  protected final String TEXT_150 = ".getDescription(), dm_";
  protected final String TEXT_151 = ".isKey()," + NL + "                                dm_";
  protected final String TEXT_152 = ".isNullable()," + NL + "                                dm_";
  protected final String TEXT_153 = ".getRefFieldName(), dm_";
  protected final String TEXT_154 = ".getRefModuleName());" + NL + "                    }" + NL + "                    current_";
  protected final String TEXT_155 = ".initDynamicColumnsFinished();" + NL + "                }";
  protected final String TEXT_156 = NL + "                    current_";
  protected final String TEXT_157 = ".put(\"";
  protected final String TEXT_158 = "\", ";
  protected final String TEXT_159 = ".";
  protected final String TEXT_160 = ");";
  protected final String TEXT_161 = NL + "                    for (int i = 0; i < ";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = ".getColumnCount(); i++) {" + NL + "                        current_";
  protected final String TEXT_164 = ".put(";
  protected final String TEXT_165 = ".";
  protected final String TEXT_166 = ".getColumnMetadata(i).getName(),";
  protected final String TEXT_167 = NL + "                                ";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = ".getColumnValue(i));" + NL + "                    }";
  protected final String TEXT_170 = NL + "            Object data_";
  protected final String TEXT_171 = " = current_";
  protected final String TEXT_172 = ".createIndexedRecord();" + NL + "" + NL + "            writer_";
  protected final String TEXT_173 = ".write(data_";
  protected final String TEXT_174 = ");" + NL + "            " + NL + "            nb_line_";
  protected final String TEXT_175 = "++;";
  protected final String TEXT_176 = NL + "                java.util.Iterator<?> outgoingMainRecords_";
  protected final String TEXT_177 = " = ((org.talend.components.api.component.runtime.WriterWithFeedback<?, ?, ?>)writer_";
  protected final String TEXT_178 = ").getSuccessfulWrites().iterator();" + NL + "                Object outgoingMain_";
  protected final String TEXT_179 = " = null;" + NL + "                if (outgoingMainRecords_";
  protected final String TEXT_180 = ".hasNext()) {" + NL + "                    outgoingMain_";
  protected final String TEXT_181 = " = outgoingMainRecords_";
  protected final String TEXT_182 = ".next();" + NL + "                    if(outgoingMainRecords_";
  protected final String TEXT_183 = ".hasNext()){" + NL + "                    \toutgoingMain_";
  protected final String TEXT_184 = " = data_";
  protected final String TEXT_185 = ";" + NL + "                    }" + NL + "                }";
  protected final String TEXT_186 = NL + "                else{" + NL + "                \tif (!((org.talend.components.api.component.runtime.WriterWithFeedback<?, ?, ?>)writer_";
  protected final String TEXT_187 = ").getRejectedWrites().iterator().hasNext()) {" + NL + "                \t\toutgoingMain_";
  protected final String TEXT_188 = " = data_";
  protected final String TEXT_189 = ";" + NL + "                \t}" + NL + "                }";
  protected final String TEXT_190 = NL + "                if(outgoingMain_";
  protected final String TEXT_191 = "!=null){" + NL + "                \t";
  protected final String TEXT_192 = " = new ";
  protected final String TEXT_193 = "Struct();" + NL + "                \t";
  protected final String TEXT_194 = NL + "                }";
  protected final String TEXT_195 = NL + "                java.util.Iterator<?> outgoingRejectRecords_";
  protected final String TEXT_196 = " = ((org.talend.components.api.component.runtime.WriterWithFeedback<?, ?, ?>)writer_";
  protected final String TEXT_197 = ").getRejectedWrites().iterator();" + NL + "                if (outgoingRejectRecords_";
  protected final String TEXT_198 = ".hasNext()) {";
  protected final String TEXT_199 = NL + "                    ";
  protected final String TEXT_200 = " = new ";
  protected final String TEXT_201 = "Struct();" + NL + "                    Object outgoingReject_";
  protected final String TEXT_202 = " = outgoingRejectRecords_";
  protected final String TEXT_203 = ".next();";
  protected final String TEXT_204 = NL + "                }";
  protected final String TEXT_205 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

/**
 * Utility for generating code that can turn an IndexedRecording coming from a
 * generic component into a rowStruct expected by the Studio.
 */
class IndexedRecordToRowStructGenerator {

    /** A unique tag for generating code variables, usually based on the cid
     *  of the node. */
    private final String cid;

    /** The columns in the rowStruct to generate. */
    private final List<IMetadataColumn> columns;

    /** The connection that we're generating code for. */
    private final IConnection connection;

    /** If there is a dynamic column, its name.  Null if none. */
    private final String dynamicColName;

    /** Variable names generated in code used by this utility. */
    private final String codeVarSchemaEnforcer;
    private final String codeVarIsDynamicInitialized;
    private final String codeVarDynamic;
    private final String codeVarIndexedRecordAdapter;

    public IndexedRecordToRowStructGenerator(String cid, IConnection connection) {
        this(cid, connection, connection.getMetadataTable().getListColumns());
    }

    public IndexedRecordToRowStructGenerator(String cid, IConnection connection, List<IMetadataColumn> columns) {
        this.cid = cid;
        this.connection = connection;
        this.columns = columns;

        String tmpDynamicColName = null;
        for (IMetadataColumn column : columns) {
            if (column.getTalendType().equals("id_Dynamic")) {
                tmpDynamicColName = column.getLabel();
                break;
            }
        }
        dynamicColName = tmpDynamicColName;

        this.codeVarSchemaEnforcer = "current_" + cid;
        this.codeVarIsDynamicInitialized = "initDyn_" + cid;
        this.codeVarDynamic = "dynamic_" + cid;
        this.codeVarIndexedRecordAdapter = "factory_" + cid;
    }

    public IConnection getConnection() {
        return connection;
    }

    /**
     * Generate code that declares and initializes the variables that are used
     * in the code generated by this utility.
     */
    public void generateInitialVariables(String codeVarSchemaToEnforce, boolean dynamicByPosition) {
        if (dynamicColName != null) {
            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(codeVarIsDynamicInitialized);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_3);
    
        }

        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(codeVarSchemaToEnforce);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dynamicByPosition);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_8);
    
    }

    /**
     * Generate code that copies data from the IndexedRecord to the rowStruct.
     *
     * @param codeVarIndexedRecord the name of the variable that contains the
     *    IndexedRecord.
     * @param codeVarRowStruct the name of the variable that contains the
     *    rowStruct.
     */
    public void generateConvertRecord(String codeVarIndexedRecord, String codeVarRowStruct) {
        generateConvertRecord(codeVarIndexedRecord, codeVarRowStruct, columns);
    }

    /**
     * Generate code that copies data from the IndexedRecord to the rowStruct.
     *
     * @param codeVarIndexedRecord the name of the variable that contains the
     *    IndexedRecord.
     * @param codeVarRowStruct the name of the variable that contains the
     *    rowStruct.
     * @param columnsToGenerate the list of columns in the rowStruct to generate
     *    code for.
     */
    public void generateConvertRecord(String codeVarIndexedRecord, String codeVarRowStruct, List<IMetadataColumn> columnsToGenerate) {
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(codeVarIndexedRecord);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(codeVarIndexedRecord);
    stringBuffer.append(TEXT_17);
    

        if (dynamicColName != null) {
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(codeVarIsDynamicInitialized);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(JavaTypesManager.LIST.getId());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(JavaTypesManager.BOOLEAN.getId());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(JavaTypesManager.BYTE_ARRAY.getId());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(JavaTypesManager.BYTE_ARRAY.getId());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(JavaTypesManager.DOUBLE.getId());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(JavaTypesManager.FLOAT.getId());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(JavaTypesManager.INTEGER.getId());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(JavaTypesManager.DATE.getId());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(JavaTypesManager.LONG.getId());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(JavaTypesManager.STRING.getId());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(JavaTypesManager.STRING.getId());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_96);
    
        }

        for (int i = 0; i < columnsToGenerate.size(); i++) {
            IMetadataColumn column = columnsToGenerate.get(i);
            String columnName = column.getLabel();
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
            if (columnName.equals(dynamicColName)) {
                
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(dynamicColName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_114);
    
            } else {
                
    stringBuffer.append(TEXT_115);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_121);
    
                    if (javaType == JavaTypesManager.STRING) {
                        
    stringBuffer.append(TEXT_122);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_126);
    
                    } else  {
                        
    stringBuffer.append(TEXT_127);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_132);
    
                    }
                    
    stringBuffer.append(TEXT_133);
    
            }
        }
    }

}

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
Component component = (Component)node.getComponent();
ComponentDefinition def = component.getComponentDefinition();

if(def instanceof org.talend.components.api.component.OutputComponentDefinition){
    // These will be initialized if there are outgoing connections and will be
    // null if there isn't a corresponding outgoing connection.
    IndexedRecordToRowStructGenerator mainIrToRow = null;
    IndexedRecordToRowStructGenerator rejectIrToRow = null;

    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    if (outgoingConns!=null){
        for (int i = 0; i < outgoingConns.size(); i++) {
            IConnection outgoingConn = outgoingConns.get(i);
            if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                
    stringBuffer.append(TEXT_134);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_135);
    
            }
            if ("MAIN".equals(outgoingConn.getConnectorName())) {
                mainIrToRow = new IndexedRecordToRowStructGenerator(cid + "OutMain",
                        outgoingConn);
            }
            if ("REJECT".equals(outgoingConn.getConnectorName())) {
                rejectIrToRow = new IndexedRecordToRowStructGenerator(cid + "OutReject",
                        outgoingConn);
            }
        }
    }

    // Generate the code to handle the incoming records.
    IConnection inputConn = null;
    List< ? extends IConnection> inputConns = node.getIncomingConnections();
    if(inputConns!=null) {
	   	for (IConnection conn : inputConns) {
	   		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	   			inputConn = conn;
	    	}
	   	}
   	}

   	boolean hasValidInput = inputConn!=null;

   	IMetadataTable metadata;
    List<IMetadataTable> metadatas = node.getMetadataList();
    boolean haveValidNodeMetadata = ((metadatas != null) && (metadatas.size() > 0) && (metadata = metadatas.get(0)) != null);

    if (hasValidInput && haveValidNodeMetadata) {
        List<IMetadataColumn> input_columnList = inputConn.getMetadataTable().getListColumns();

        if (input_columnList!=null && !input_columnList.isEmpty()) {
            // If there are dynamic columns in the schema, they need to be
            // initialized into the runtime schema of the actual IndexedRecord
            // provided to the component.

            int dynamicPos = -1;
	        for (int i = 0; i < input_columnList.size(); i++) {
	            if (input_columnList.get(i).getTalendType().equals("id_Dynamic")) {
	                dynamicPos = i;
	                break;
	            }
	        }

            if (dynamicPos != -1)  {
                
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(input_columnList.get(dynamicPos).getLabel());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
            }

            for (int i = 0; i < input_columnList.size(); i++) { // column
                IMetadataColumn column = input_columnList.get(i);
                if (dynamicPos != i) {
                    
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_160);
    
                } else {
                    
    stringBuffer.append(TEXT_161);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_169);
    
                }
            } // column

            // If necesary, generate the code to handle outgoing connections.
            // TODO: For now, this can only handle one outgoing record for
            // each incoming record.  To handle multiple outgoing records, code
            // generation needs to occur in component_begin in order to open
            // a for() loop.

            // There will be a ClassCastException if the output component does
            // not implement WriterWithFeedback, but permits outgoing
            // connections.

            
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    
            if (mainIrToRow != null) {
                
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
                if (rejectIrToRow == null) {
                
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
                }
                
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(mainIrToRow.getConnection().getName());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(mainIrToRow.getConnection().getName() );
    stringBuffer.append(TEXT_193);
    
                    mainIrToRow.generateConvertRecord("outgoingMain_" + cid, mainIrToRow.getConnection().getName());
                    
    stringBuffer.append(TEXT_194);
    
            }
            if (rejectIrToRow != null) {
                
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(rejectIrToRow.getConnection().getName());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(rejectIrToRow.getConnection().getName() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
                    rejectIrToRow.generateConvertRecord("outgoingReject_" + cid, rejectIrToRow.getConnection().getName());
                    
    stringBuffer.append(TEXT_204);
    
            }
        }
    }
} // canStart

    stringBuffer.append(TEXT_205);
    return stringBuffer.toString();
  }
}
