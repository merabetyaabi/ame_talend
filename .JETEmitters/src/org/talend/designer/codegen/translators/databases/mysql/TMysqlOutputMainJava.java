package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.process.IProcess;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TMysqlOutputMainJava {
  protected static String nl;
  public static synchronized TMysqlOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlOutputMainJava result = new TMysqlOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "                if(log.is";
  protected final String TEXT_4 = "Enabled())";
  protected final String TEXT_5 = NL + "            log.";
  protected final String TEXT_6 = "(\"";
  protected final String TEXT_7 = " - \" ";
  protected final String TEXT_8 = " + ";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "            StringBuilder ";
  protected final String TEXT_12 = " = new StringBuilder();";
  protected final String TEXT_13 = NL + "            ";
  protected final String TEXT_14 = ".append(\"Parameters:\");";
  protected final String TEXT_15 = NL + "                    ";
  protected final String TEXT_16 = ".append(\"";
  protected final String TEXT_17 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_18 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_19 = NL + "                    ";
  protected final String TEXT_20 = ".append(\"";
  protected final String TEXT_21 = "\" + \" = \" + ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "                ";
  protected final String TEXT_24 = ".append(\" | \");";
  protected final String TEXT_25 = NL + "            StringBuilder ";
  protected final String TEXT_26 = " = new StringBuilder();    ";
  protected final String TEXT_27 = NL + "                    ";
  protected final String TEXT_28 = ".append(";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "                    if(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " == null){";
  protected final String TEXT_34 = NL + "                        ";
  protected final String TEXT_35 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_36 = NL + "                        ";
  protected final String TEXT_37 = ".append(";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ");" + NL + "                    }   ";
  protected final String TEXT_40 = NL + "                ";
  protected final String TEXT_41 = ".append(\"|\");";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = NL + "            ";
  protected final String TEXT_44 = " = null;";
  protected final String TEXT_45 = NL + "        if(nb_line_";
  protected final String TEXT_46 = "==0) {";
  protected final String TEXT_47 = NL + "            java.sql.Statement stmtDrop_";
  protected final String TEXT_48 = " = conn_";
  protected final String TEXT_49 = ".createStatement();";
  protected final String TEXT_50 = NL + "                              stmtDrop_";
  protected final String TEXT_51 = ".setQueryTimeout(Integer.valueOf(Integer.valueOf(";
  protected final String TEXT_52 = ")));";
  protected final String TEXT_53 = NL + "            stmtDrop_";
  protected final String TEXT_54 = ".execute(\"";
  protected final String TEXT_55 = "\" ";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "            stmtDrop_";
  protected final String TEXT_58 = ".close();" + NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_59 = " = conn_";
  protected final String TEXT_60 = ".createStatement();";
  protected final String TEXT_61 = NL + "                              stmtCreate_";
  protected final String TEXT_62 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_63 = "));";
  protected final String TEXT_64 = NL + "                    stmtCreate_";
  protected final String TEXT_65 = ".execute(((\"";
  protected final String TEXT_66 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = ", \"";
  protected final String TEXT_69 = "\")";
  protected final String TEXT_70 = ".toUpperCase()";
  protected final String TEXT_71 = ")+\")";
  protected final String TEXT_72 = "\"));";
  protected final String TEXT_73 = NL + "                stmtCreate_";
  protected final String TEXT_74 = ".execute(\"";
  protected final String TEXT_75 = ")\");";
  protected final String TEXT_76 = NL + "            stmtCreate_";
  protected final String TEXT_77 = ".close();";
  protected final String TEXT_78 = NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_79 = " = conn_";
  protected final String TEXT_80 = ".createStatement();";
  protected final String TEXT_81 = NL + "                              stmtCreate_";
  protected final String TEXT_82 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_83 = "));";
  protected final String TEXT_84 = NL + "                    stmtCreate_";
  protected final String TEXT_85 = ".execute(((\"";
  protected final String TEXT_86 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = ", \"";
  protected final String TEXT_89 = "\")";
  protected final String TEXT_90 = ".toUpperCase()";
  protected final String TEXT_91 = ")+\")";
  protected final String TEXT_92 = "\"));";
  protected final String TEXT_93 = NL + "                stmtCreate_";
  protected final String TEXT_94 = ".execute(\"";
  protected final String TEXT_95 = ")\");";
  protected final String TEXT_96 = NL + "            stmtCreate_";
  protected final String TEXT_97 = ".close();";
  protected final String TEXT_98 = NL;
  protected final String TEXT_99 = NL + "                    String keyCheckTable_";
  protected final String TEXT_100 = " = \"[Informix]\"+\"[\"+";
  protected final String TEXT_101 = "+\"][\"+";
  protected final String TEXT_102 = "+\"][\"+";
  protected final String TEXT_103 = "+\"][\"+";
  protected final String TEXT_104 = "+\"][\"+";
  protected final String TEXT_105 = "+\"]\"+ \"[checktable]\" + \"[\" + ";
  protected final String TEXT_106 = " + \"]\";";
  protected final String TEXT_107 = NL + "                    // [%connection%][checktable][tableName]" + NL + "                    String keyCheckTable_";
  protected final String TEXT_108 = " = conn_";
  protected final String TEXT_109 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_110 = " + \"]\";";
  protected final String TEXT_111 = NL + NL + "                if(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_112 = ")== null){//}" + NL + "" + NL + "                    synchronized (GlobalResource.resourceLockMap.get(keyCheckTable_";
  protected final String TEXT_113 = ")) {//}" + NL + "                        if(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_114 = ")== null){//}";
  protected final String TEXT_115 = NL + "                                java.sql.Statement isExistStmt_";
  protected final String TEXT_116 = " = conn_";
  protected final String TEXT_117 = ".createStatement();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_118 = " = false;" + NL + "                                try {" + NL + "                                    isExistStmt_";
  protected final String TEXT_119 = ".execute(\"SELECT TOP 1 1 FROM [\" +  tableName_";
  protected final String TEXT_120 = " + \"]\" );" + NL + "                                    whetherExist_";
  protected final String TEXT_121 = " = true;" + NL + "                                } catch (java.lang.Exception e){" + NL + "                                    whetherExist_";
  protected final String TEXT_122 = " = false;" + NL + "                                }" + NL + "                                isExistStmt_";
  protected final String TEXT_123 = ".close();";
  protected final String TEXT_124 = NL + "                                ";
  protected final String TEXT_125 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_126 = " = conn_";
  protected final String TEXT_127 = ".getMetaData();" + NL + "                                if(tableNameForSearch_";
  protected final String TEXT_128 = ".indexOf(\"\\\"\")==-1){" + NL + "                                    tableNameForSearch_";
  protected final String TEXT_129 = " = tableNameForSearch_";
  protected final String TEXT_130 = ".toUpperCase();" + NL + "                                }else{" + NL + "                                    tableNameForSearch_";
  protected final String TEXT_131 = " = tableNameForSearch_";
  protected final String TEXT_132 = ".replaceAll(\"\\\"\",\"\");" + NL + "                                }" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_133 = " = dbMetaData_";
  protected final String TEXT_134 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_135 = ", tableNameForSearch_";
  protected final String TEXT_136 = ", new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_137 = " = false;" + NL + "                                if(rsTable_";
  protected final String TEXT_138 = ".next()) {" + NL + "                                    whetherExist_";
  protected final String TEXT_139 = " = true;" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_140 = ".close();" + NL;
  protected final String TEXT_141 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_142 = " = conn_";
  protected final String TEXT_143 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_144 = " = dbMetaData_";
  protected final String TEXT_145 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_146 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_147 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_148 = " = rsTable_";
  protected final String TEXT_149 = ".getString(\"TABLE_NAME\");" + NL + "                                    String schema_";
  protected final String TEXT_150 = " = rsTable_";
  protected final String TEXT_151 = ".getString(\"TABLE_SCHEM\");" + NL + "                                    if(table_";
  protected final String TEXT_152 = ".equals";
  protected final String TEXT_153 = "IgnoreCase";
  protected final String TEXT_154 = "(";
  protected final String TEXT_155 = ")" + NL + "                                        && (schema_";
  protected final String TEXT_156 = ".equals";
  protected final String TEXT_157 = "IgnoreCase";
  protected final String TEXT_158 = "(dbschema_";
  protected final String TEXT_159 = ") || dbschema_";
  protected final String TEXT_160 = ".trim().length() ==0)) {" + NL + "                                        whetherExist_";
  protected final String TEXT_161 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_162 = ".close();";
  protected final String TEXT_163 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_164 = " = conn_";
  protected final String TEXT_165 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_166 = " = dbMetaData_";
  protected final String TEXT_167 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_168 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_169 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_170 = " = rsTable_";
  protected final String TEXT_171 = ".getString(\"TABLE_NAME\");" + NL + "                                    String schema_";
  protected final String TEXT_172 = " = rsTable_";
  protected final String TEXT_173 = ".getString(\"TABLE_SCHEM\");" + NL + "                                    if(table_";
  protected final String TEXT_174 = ".equals";
  protected final String TEXT_175 = "IgnoreCase";
  protected final String TEXT_176 = "((";
  protected final String TEXT_177 = ")";
  protected final String TEXT_178 = ".toUpperCase()";
  protected final String TEXT_179 = ")" + NL + "                                        && (schema_";
  protected final String TEXT_180 = ".equals";
  protected final String TEXT_181 = "IgnoreCase";
  protected final String TEXT_182 = "(dbschema_";
  protected final String TEXT_183 = ") || (dbschema_";
  protected final String TEXT_184 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_185 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_186 = ")))) {" + NL + "                                        whetherExist_";
  protected final String TEXT_187 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_188 = ".close();";
  protected final String TEXT_189 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_190 = " = conn_";
  protected final String TEXT_191 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_192 = " = dbMetaData_";
  protected final String TEXT_193 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_194 = " = false;" + NL + "                                String defaultSchema_";
  protected final String TEXT_195 = " = \"public\";" + NL + "                                if(dbschema_";
  protected final String TEXT_196 = " == null || dbschema_";
  protected final String TEXT_197 = ".trim().length() == 0) {" + NL + "                                    java.sql.Statement stmtSchema_";
  protected final String TEXT_198 = " = conn_";
  protected final String TEXT_199 = ".createStatement();" + NL + "                                    java.sql.ResultSet rsSchema_";
  protected final String TEXT_200 = " = stmtSchema_";
  protected final String TEXT_201 = ".executeQuery(\"select current_schema() \");" + NL + "                                    while(rsSchema_";
  protected final String TEXT_202 = ".next()){" + NL + "                                        defaultSchema_";
  protected final String TEXT_203 = " = rsSchema_";
  protected final String TEXT_204 = ".getString(\"current_schema\");" + NL + "                                    }" + NL + "                                    rsSchema_";
  protected final String TEXT_205 = ".close();" + NL + "                                    stmtSchema_";
  protected final String TEXT_206 = ".close();" + NL + "                                }" + NL + "                                while(rsTable_";
  protected final String TEXT_207 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_208 = " = rsTable_";
  protected final String TEXT_209 = ".getString(\"TABLE_NAME\");" + NL + "                                    String schema_";
  protected final String TEXT_210 = " = rsTable_";
  protected final String TEXT_211 = ".getString(\"TABLE_SCHEM\");" + NL + "                                    if(table_";
  protected final String TEXT_212 = ".equals";
  protected final String TEXT_213 = "IgnoreCase";
  protected final String TEXT_214 = "(";
  protected final String TEXT_215 = ")" + NL + "                                        && (schema_";
  protected final String TEXT_216 = ".equals";
  protected final String TEXT_217 = "IgnoreCase";
  protected final String TEXT_218 = "(dbschema_";
  protected final String TEXT_219 = ") || ((dbschema_";
  protected final String TEXT_220 = " ==null || dbschema_";
  protected final String TEXT_221 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_222 = ".equals";
  protected final String TEXT_223 = "IgnoreCase";
  protected final String TEXT_224 = "(schema_";
  protected final String TEXT_225 = ")))) {" + NL + "                                        whetherExist_";
  protected final String TEXT_226 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_227 = ".close();";
  protected final String TEXT_228 = NL + "\t\t\t\t            \tString tableForSearch_";
  protected final String TEXT_229 = " = ";
  protected final String TEXT_230 = ";" + NL + "\t\t\t\t            \tif(tableForSearch_";
  protected final String TEXT_231 = " != null){" + NL + "\t\t\t\t            \t\tif(tableForSearch_";
  protected final String TEXT_232 = ".startsWith(\"\\\"\") && tableForSearch_";
  protected final String TEXT_233 = ".endsWith(\"\\\"\")){" + NL + "\t\t\t\t            \t\t\ttableForSearch_";
  protected final String TEXT_234 = " =  tableForSearch_";
  protected final String TEXT_235 = ".substring(1,tableForSearch_";
  protected final String TEXT_236 = ".length()-1);" + NL + "\t\t\t\t            \t\t}else{" + NL + "\t\t\t\t            \t\t\ttableForSearch_";
  protected final String TEXT_237 = " =  tableForSearch_";
  protected final String TEXT_238 = ".toUpperCase();" + NL + "\t\t\t\t            \t\t}" + NL + "\t\t\t\t            \t}" + NL + "\t\t\t\t                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_239 = " = conn_";
  protected final String TEXT_240 = ".getMetaData();" + NL + "\t\t\t\t                java.sql.ResultSet rsTable_";
  protected final String TEXT_241 = " = dbMetaData_";
  protected final String TEXT_242 = ".getTables(null, conn_";
  protected final String TEXT_243 = ".getSchema(), tableForSearch_";
  protected final String TEXT_244 = ", new String[]{\"TABLE\"});" + NL + "\t\t\t\t                boolean whetherExist_";
  protected final String TEXT_245 = " = false;" + NL + "\t\t\t\t               \tif(rsTable_";
  protected final String TEXT_246 = ".next()) {" + NL + "\t\t\t\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_247 = " = true;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t                rsTable_";
  protected final String TEXT_248 = ".close();" + NL + "\t\t\t\t            ";
  protected final String TEXT_249 = NL + "\t\t\t\t                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_250 = " = conn_";
  protected final String TEXT_251 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_252 = " = dbMetaData_";
  protected final String TEXT_253 = ".getTables(null, schemaForSearch_";
  protected final String TEXT_254 = ", null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_255 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_256 = ".next()) {" + NL + "                                    if(rsTable_";
  protected final String TEXT_257 = ".getString(\"TABLE_NAME\").equalsIgnoreCase(tableForSearch_";
  protected final String TEXT_258 = ")) {" + NL + "                                        whetherExist_";
  protected final String TEXT_259 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_260 = ".close();";
  protected final String TEXT_261 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_262 = " = conn_";
  protected final String TEXT_263 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_264 = " = dbMetaData_";
  protected final String TEXT_265 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_266 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_267 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_268 = " = rsTable_";
  protected final String TEXT_269 = ".getString(\"TABLE_NAME\");" + NL + "                                    if(table_";
  protected final String TEXT_270 = ".equalsIgnoreCase(";
  protected final String TEXT_271 = ")) {" + NL + "                                        whetherExist_";
  protected final String TEXT_272 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_273 = ".close();";
  protected final String TEXT_274 = NL + "                                if(!whetherExist_";
  protected final String TEXT_275 = ") {" + NL + "                                    java.sql.Statement stmtCreate_";
  protected final String TEXT_276 = " = conn_";
  protected final String TEXT_277 = ".createStatement();";
  protected final String TEXT_278 = NL + "                                                      stmtCreate_";
  protected final String TEXT_279 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_280 = "));";
  protected final String TEXT_281 = NL + "                                            stmtCreate_";
  protected final String TEXT_282 = ".execute(((\"";
  protected final String TEXT_283 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_284 = ".";
  protected final String TEXT_285 = ", \"";
  protected final String TEXT_286 = "\")";
  protected final String TEXT_287 = ".toUpperCase()";
  protected final String TEXT_288 = ")+\")";
  protected final String TEXT_289 = "\"));";
  protected final String TEXT_290 = NL + "                                        stmtCreate_";
  protected final String TEXT_291 = ".execute(\"";
  protected final String TEXT_292 = ")\");";
  protected final String TEXT_293 = NL + "                                    stmtCreate_";
  protected final String TEXT_294 = ".close();" + NL + "                                }";
  protected final String TEXT_295 = NL + "                                if(whetherExist_";
  protected final String TEXT_296 = ") {" + NL + "                                    java.sql.Statement stmtDrop_";
  protected final String TEXT_297 = " = conn_";
  protected final String TEXT_298 = ".createStatement();";
  protected final String TEXT_299 = NL + "                                                      stmtDrop_";
  protected final String TEXT_300 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_301 = "));";
  protected final String TEXT_302 = NL + "                                    stmtDrop_";
  protected final String TEXT_303 = ".execute(\"";
  protected final String TEXT_304 = "\" ";
  protected final String TEXT_305 = ");";
  protected final String TEXT_306 = NL + "                                    stmtDrop_";
  protected final String TEXT_307 = ".close();" + NL + "                                }" + NL + "                                java.sql.Statement stmtCreate_";
  protected final String TEXT_308 = " = conn_";
  protected final String TEXT_309 = ".createStatement();";
  protected final String TEXT_310 = NL + "                                                  stmtCreate_";
  protected final String TEXT_311 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_312 = "));";
  protected final String TEXT_313 = NL + "                                        stmtCreate_";
  protected final String TEXT_314 = ".execute(((\"";
  protected final String TEXT_315 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_316 = ".";
  protected final String TEXT_317 = ", \"";
  protected final String TEXT_318 = "\")";
  protected final String TEXT_319 = ".toUpperCase()";
  protected final String TEXT_320 = ")+\")";
  protected final String TEXT_321 = "\"));";
  protected final String TEXT_322 = NL + "                                    stmtCreate_";
  protected final String TEXT_323 = ".execute(\"";
  protected final String TEXT_324 = ")\");";
  protected final String TEXT_325 = NL + "                                stmtCreate_";
  protected final String TEXT_326 = ".close();";
  protected final String TEXT_327 = NL + "                            GlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_328 = ", true);" + NL + "            //{{{" + NL + "                        } // end of if" + NL + "                    } // end synchronized" + NL + "                }";
  protected final String TEXT_329 = NL + "            java.sql.Statement stmtClear_";
  protected final String TEXT_330 = " = conn_";
  protected final String TEXT_331 = ".createStatement();";
  protected final String TEXT_332 = NL + "                              stmtClear_";
  protected final String TEXT_333 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_334 = "));";
  protected final String TEXT_335 = NL + "            stmtClear_";
  protected final String TEXT_336 = ".executeUpdate(\"";
  protected final String TEXT_337 = "\");";
  protected final String TEXT_338 = NL + "            stmtClear_";
  protected final String TEXT_339 = ".close();";
  protected final String TEXT_340 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_341 = " = conn_";
  protected final String TEXT_342 = ".createStatement();";
  protected final String TEXT_343 = NL + "                              stmtTruncCount_";
  protected final String TEXT_344 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_345 = "));";
  protected final String TEXT_346 = NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_347 = " = stmtTruncCount_";
  protected final String TEXT_348 = ".executeQuery(\"";
  protected final String TEXT_349 = "\");" + NL + "            int rsTruncCountNumber_";
  protected final String TEXT_350 = " = 0;" + NL + "            if(rsTruncCount_";
  protected final String TEXT_351 = ".next()) {" + NL + "                rsTruncCountNumber_";
  protected final String TEXT_352 = " = rsTruncCount_";
  protected final String TEXT_353 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_354 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_355 = ".close();" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_356 = " = conn_";
  protected final String TEXT_357 = ".createStatement();";
  protected final String TEXT_358 = NL + "                              stmtTrunc_";
  protected final String TEXT_359 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_360 = "));";
  protected final String TEXT_361 = NL + "                conn_";
  protected final String TEXT_362 = ".commit();";
  protected final String TEXT_363 = NL + "            stmtTrunc_";
  protected final String TEXT_364 = ".executeUpdate(\"";
  protected final String TEXT_365 = "\");";
  protected final String TEXT_366 = NL + "                if(!conn_";
  protected final String TEXT_367 = ".getAutoCommit()){" + NL + "                    conn_";
  protected final String TEXT_368 = ".commit();" + NL + "                }";
  protected final String TEXT_369 = NL + "            deletedCount_";
  protected final String TEXT_370 = " += rsTruncCountNumber_";
  protected final String TEXT_371 = ";" + NL + "            stmtTrunc_";
  protected final String TEXT_372 = ".close();";
  protected final String TEXT_373 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_374 = " = conn_";
  protected final String TEXT_375 = ".createStatement();" + NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_376 = " = stmtTruncCount_";
  protected final String TEXT_377 = ".executeQuery(\"";
  protected final String TEXT_378 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_379 = " = conn_";
  protected final String TEXT_380 = ".createStatement();";
  protected final String TEXT_381 = NL + "                conn_";
  protected final String TEXT_382 = ".commit();";
  protected final String TEXT_383 = NL + "            stmtTrunc_";
  protected final String TEXT_384 = ".executeUpdate(\"";
  protected final String TEXT_385 = "\");";
  protected final String TEXT_386 = NL + "            while(rsTruncCount_";
  protected final String TEXT_387 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_388 = " += rsTruncCount_";
  protected final String TEXT_389 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_390 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_391 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_392 = ".close();";
  protected final String TEXT_393 = NL + "            StringBuffer duplidateClause_";
  protected final String TEXT_394 = " = new StringBuffer(\" ON DUPLICATE KEY UPDATE \");";
  protected final String TEXT_395 = NL + "                        duplidateClause_";
  protected final String TEXT_396 = ".append(\",\");";
  protected final String TEXT_397 = NL + "                        duplidateClause_";
  protected final String TEXT_398 = ".append (\"`\" +  ";
  protected final String TEXT_399 = " + \"`\");" + NL + "                        duplidateClause_";
  protected final String TEXT_400 = ".append (\"=\");" + NL + "                        duplidateClause_";
  protected final String TEXT_401 = ".append (";
  protected final String TEXT_402 = ");";
  protected final String TEXT_403 = NL;
  protected final String TEXT_404 = NL + "                        String insert_";
  protected final String TEXT_405 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_406 = " + \"` (";
  protected final String TEXT_407 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_408 = ".";
  protected final String TEXT_409 = ", \"";
  protected final String TEXT_410 = "\")+\") VALUES (";
  protected final String TEXT_411 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_412 = ".";
  protected final String TEXT_413 = ")+\")\";";
  protected final String TEXT_414 = NL + "                        String insert_";
  protected final String TEXT_415 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_416 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_417 = ".";
  protected final String TEXT_418 = ", \"";
  protected final String TEXT_419 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_420 = ".";
  protected final String TEXT_421 = ")+\")\";";
  protected final String TEXT_422 = NL + "                insert_";
  protected final String TEXT_423 = " +=  duplidateClause_";
  protected final String TEXT_424 = ".toString();";
  protected final String TEXT_425 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_426 = " = new StringBuffer(insert_";
  protected final String TEXT_427 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_428 = ".insert(insert_";
  protected final String TEXT_429 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_430 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_431 = " =insertStringBuffer_";
  protected final String TEXT_432 = ".toString(); ";
  protected final String TEXT_433 = "    " + NL;
  protected final String TEXT_434 = NL + "                        pstmt_";
  protected final String TEXT_435 = " = conn_";
  protected final String TEXT_436 = ".prepareStatement(insert_";
  protected final String TEXT_437 = ");";
  protected final String TEXT_438 = NL;
  protected final String TEXT_439 = NL + "                        pstmt_";
  protected final String TEXT_440 = " = null;" + NL + "                        // [%connection%][psmt][tableName]" + NL + "                        String keyPsmt_";
  protected final String TEXT_441 = " = conn_";
  protected final String TEXT_442 = " + \"[psmt]\" + \"[\" + ";
  protected final String TEXT_443 = " + \"]\";" + NL + "                        if(GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_444 = ")== null){" + NL + "                            pstmt_";
  protected final String TEXT_445 = " = conn_";
  protected final String TEXT_446 = ".prepareStatement(insert_";
  protected final String TEXT_447 = ");" + NL + "                            GlobalResource.resourceMap.put(keyPsmt_";
  protected final String TEXT_448 = ", pstmt_";
  protected final String TEXT_449 = ");" + NL + "                        }else{" + NL + "                            pstmt_";
  protected final String TEXT_450 = " = (java.sql.PreparedStatement)GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_451 = ");" + NL + "                        }";
  protected final String TEXT_452 = NL;
  protected final String TEXT_453 = NL + "                ////////////////////////////////////////////////////////////////////////////////////////////" + NL + "" + NL + "" + NL + "                StringBuilder extendInsertValueStmt_";
  protected final String TEXT_454 = " = new StringBuilder();" + NL + "                for(int i=0;i < ";
  protected final String TEXT_455 = ";i++){";
  protected final String TEXT_456 = NL + "                    extendInsertValueStmt_";
  protected final String TEXT_457 = ".append(\"(";
  protected final String TEXT_458 = ",\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_459 = ".";
  protected final String TEXT_460 = ")+\")\");";
  protected final String TEXT_461 = NL + "                    extendInsertValueStmt_";
  protected final String TEXT_462 = ".append(\"(";
  protected final String TEXT_463 = ")\");";
  protected final String TEXT_464 = NL + "                if (i!=";
  protected final String TEXT_465 = "-1) extendInsertValueStmt_";
  protected final String TEXT_466 = ".append(\",\");" + NL + "                }";
  protected final String TEXT_467 = NL + "                        insert_";
  protected final String TEXT_468 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_469 = " + \"` (";
  protected final String TEXT_470 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_471 = ".";
  protected final String TEXT_472 = ", \"";
  protected final String TEXT_473 = "\")+\") VALUES \" + extendInsertValueStmt_";
  protected final String TEXT_474 = ".toString();";
  protected final String TEXT_475 = NL + "                        insert_";
  protected final String TEXT_476 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_477 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_478 = ".";
  protected final String TEXT_479 = ", \"";
  protected final String TEXT_480 = "\")+\") VALUES \" + extendInsertValueStmt_";
  protected final String TEXT_481 = ".toString();";
  protected final String TEXT_482 = NL + "                    insert_";
  protected final String TEXT_483 = " +=  duplidateClause_";
  protected final String TEXT_484 = ".toString();";
  protected final String TEXT_485 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_486 = " = new StringBuffer(insert_";
  protected final String TEXT_487 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_488 = ".insert(insert_";
  protected final String TEXT_489 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_490 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_491 = " =insertStringBuffer_";
  protected final String TEXT_492 = ".toString(); ";
  protected final String TEXT_493 = "    " + NL + "                    pstmt_";
  protected final String TEXT_494 = " =  conn_";
  protected final String TEXT_495 = ".prepareStatement(insert_";
  protected final String TEXT_496 = ");";
  protected final String TEXT_497 = NL + NL + "                    insertColName";
  protected final String TEXT_498 = " = \"";
  protected final String TEXT_499 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_500 = ".";
  protected final String TEXT_501 = ", \"";
  protected final String TEXT_502 = "\");" + NL + "                    insertColValue";
  protected final String TEXT_503 = " =  \"";
  protected final String TEXT_504 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_505 = ".";
  protected final String TEXT_506 = ");";
  protected final String TEXT_507 = NL + "                    insertColName";
  protected final String TEXT_508 = " = DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_509 = ".";
  protected final String TEXT_510 = ", \"";
  protected final String TEXT_511 = "\");" + NL + "                    insertColValue";
  protected final String TEXT_512 = " =  DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_513 = ".";
  protected final String TEXT_514 = ");";
  protected final String TEXT_515 = NL + "                rowCount";
  protected final String TEXT_516 = " = 0;";
  protected final String TEXT_517 = NL + "                int rowCount";
  protected final String TEXT_518 = " = 0;";
  protected final String TEXT_519 = NL + "                        String insert_";
  protected final String TEXT_520 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_521 = " + \"` (";
  protected final String TEXT_522 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_523 = ".";
  protected final String TEXT_524 = ", \"";
  protected final String TEXT_525 = "\")+\") VALUES (";
  protected final String TEXT_526 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_527 = ".";
  protected final String TEXT_528 = ")+\")\";";
  protected final String TEXT_529 = NL + "                        String insert_";
  protected final String TEXT_530 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_531 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_532 = ".";
  protected final String TEXT_533 = ", \"";
  protected final String TEXT_534 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_535 = ".";
  protected final String TEXT_536 = ")+\")\";";
  protected final String TEXT_537 = NL + "                        insert_";
  protected final String TEXT_538 = " +=  duplidateClause_";
  protected final String TEXT_539 = ".toString();";
  protected final String TEXT_540 = NL + "                        batchSize_";
  protected final String TEXT_541 = " = ";
  protected final String TEXT_542 = ";" + NL + "                        batchSizeCounter_";
  protected final String TEXT_543 = "=0;";
  protected final String TEXT_544 = NL + "                        int batchSize_";
  protected final String TEXT_545 = " = ";
  protected final String TEXT_546 = ";" + NL + "                        int batchSizeCounter_";
  protected final String TEXT_547 = "=0;";
  protected final String TEXT_548 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_549 = " = new StringBuffer(insert_";
  protected final String TEXT_550 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_551 = ".insert(insert_";
  protected final String TEXT_552 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_553 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_554 = " =insertStringBuffer_";
  protected final String TEXT_555 = ".toString(); ";
  protected final String TEXT_556 = "    " + NL + "                pstmt_";
  protected final String TEXT_557 = " = conn_";
  protected final String TEXT_558 = ".prepareStatement(insert_";
  protected final String TEXT_559 = ");" + NL + NL;
  protected final String TEXT_560 = NL + "                String update_";
  protected final String TEXT_561 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_562 = " + \"` SET ";
  protected final String TEXT_563 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_564 = ".";
  protected final String TEXT_565 = ", \"";
  protected final String TEXT_566 = "\")+\" WHERE ";
  protected final String TEXT_567 = "\";";
  protected final String TEXT_568 = NL + "                String update_";
  protected final String TEXT_569 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_570 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_571 = ".";
  protected final String TEXT_572 = ", \"";
  protected final String TEXT_573 = "\")+\" WHERE ";
  protected final String TEXT_574 = "\";";
  protected final String TEXT_575 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_576 = " = new StringBuffer(update_";
  protected final String TEXT_577 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_578 = ".insert(update_";
  protected final String TEXT_579 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_580 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_581 = " =updateStringBuffer_";
  protected final String TEXT_582 = ".toString(); ";
  protected final String TEXT_583 = NL + "        pstmt_";
  protected final String TEXT_584 = " = conn_";
  protected final String TEXT_585 = ".prepareStatement(update_";
  protected final String TEXT_586 = ");";
  protected final String TEXT_587 = NL + "                    String insert_";
  protected final String TEXT_588 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_589 = " + \"` (";
  protected final String TEXT_590 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_591 = ".";
  protected final String TEXT_592 = ", \"";
  protected final String TEXT_593 = "\")+\") VALUES (";
  protected final String TEXT_594 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_595 = ".";
  protected final String TEXT_596 = ")+\")\";";
  protected final String TEXT_597 = NL + "                    String insert_";
  protected final String TEXT_598 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_599 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_600 = ".";
  protected final String TEXT_601 = ", \"";
  protected final String TEXT_602 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_603 = ".";
  protected final String TEXT_604 = ")+\")\";";
  protected final String TEXT_605 = NL + "                    String update_";
  protected final String TEXT_606 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_607 = " + \"` SET ";
  protected final String TEXT_608 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_609 = ".";
  protected final String TEXT_610 = ", \"";
  protected final String TEXT_611 = "\")+\" WHERE ";
  protected final String TEXT_612 = "\";";
  protected final String TEXT_613 = NL + "                    String update_";
  protected final String TEXT_614 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_615 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_616 = ".";
  protected final String TEXT_617 = ", \"";
  protected final String TEXT_618 = "\")+\" WHERE ";
  protected final String TEXT_619 = "\";";
  protected final String TEXT_620 = NL + "        pstmt_";
  protected final String TEXT_621 = " = conn_";
  protected final String TEXT_622 = ".prepareStatement(\"SELECT COUNT(1) FROM `\" + ";
  protected final String TEXT_623 = " + \"` WHERE ";
  protected final String TEXT_624 = "\");//String insert_";
  protected final String TEXT_625 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_626 = " + \"` (";
  protected final String TEXT_627 = ") VALUES (";
  protected final String TEXT_628 = ")\";";
  protected final String TEXT_629 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_630 = " = new StringBuffer(insert_";
  protected final String TEXT_631 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_632 = ".insert(insert_";
  protected final String TEXT_633 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_634 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_635 = " =insertStringBuffer_";
  protected final String TEXT_636 = ".toString(); ";
  protected final String TEXT_637 = "    " + NL + "        pstmtInsert_";
  protected final String TEXT_638 = " = conn_";
  protected final String TEXT_639 = ".prepareStatement(insert_";
  protected final String TEXT_640 = ");";
  protected final String TEXT_641 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_642 = " = new StringBuffer(update_";
  protected final String TEXT_643 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_644 = ".insert(update_";
  protected final String TEXT_645 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_646 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_647 = " =updateStringBuffer_";
  protected final String TEXT_648 = ".toString(); ";
  protected final String TEXT_649 = NL + "        pstmtUpdate_";
  protected final String TEXT_650 = " = conn_";
  protected final String TEXT_651 = ".prepareStatement(update_";
  protected final String TEXT_652 = ");";
  protected final String TEXT_653 = NL + "                    String insert_";
  protected final String TEXT_654 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_655 = " + \"` (";
  protected final String TEXT_656 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_657 = ".";
  protected final String TEXT_658 = ", \"";
  protected final String TEXT_659 = "\")+\") VALUES (";
  protected final String TEXT_660 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_661 = ".";
  protected final String TEXT_662 = ")+\")\";";
  protected final String TEXT_663 = NL + "                    String insert_";
  protected final String TEXT_664 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_665 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_666 = ".";
  protected final String TEXT_667 = ", \"";
  protected final String TEXT_668 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_669 = ".";
  protected final String TEXT_670 = ")+\")\";";
  protected final String TEXT_671 = NL + "                    String update_";
  protected final String TEXT_672 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_673 = " + \"` SET ";
  protected final String TEXT_674 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_675 = ".";
  protected final String TEXT_676 = ", \"";
  protected final String TEXT_677 = "\")+\" WHERE ";
  protected final String TEXT_678 = "\";";
  protected final String TEXT_679 = NL + "                    String update_";
  protected final String TEXT_680 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_681 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_682 = ".";
  protected final String TEXT_683 = ", \"";
  protected final String TEXT_684 = "\")+\" WHERE ";
  protected final String TEXT_685 = "\";";
  protected final String TEXT_686 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_687 = " = new StringBuffer(update_";
  protected final String TEXT_688 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_689 = ".insert(update_";
  protected final String TEXT_690 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_691 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_692 = " =updateStringBuffer_";
  protected final String TEXT_693 = ".toString(); ";
  protected final String TEXT_694 = NL + "        pstmtUpdate_";
  protected final String TEXT_695 = " = conn_";
  protected final String TEXT_696 = ".prepareStatement(update_";
  protected final String TEXT_697 = ");";
  protected final String TEXT_698 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_699 = " = new StringBuffer(insert_";
  protected final String TEXT_700 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_701 = ".insert(insert_";
  protected final String TEXT_702 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_703 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_704 = " =insertStringBuffer_";
  protected final String TEXT_705 = ".toString(); ";
  protected final String TEXT_706 = "    " + NL + "        pstmtInsert_";
  protected final String TEXT_707 = " = conn_";
  protected final String TEXT_708 = ".prepareStatement(insert_";
  protected final String TEXT_709 = ");";
  protected final String TEXT_710 = NL + "        String delete_";
  protected final String TEXT_711 = " = \"DELETE FROM `\" + ";
  protected final String TEXT_712 = " + \"` WHERE ";
  protected final String TEXT_713 = "\";";
  protected final String TEXT_714 = NL + "    StringBuffer deleteStringBuffer_";
  protected final String TEXT_715 = " = new StringBuffer(delete_";
  protected final String TEXT_716 = ");" + NL + "    deleteStringBuffer_";
  protected final String TEXT_717 = ".insert(delete_";
  protected final String TEXT_718 = ".indexOf(\"DELETE\")+ \"DELETE\".length()+1 , ";
  protected final String TEXT_719 = "  + \" \" );" + NL + "    delete_";
  protected final String TEXT_720 = " =deleteStringBuffer_";
  protected final String TEXT_721 = ".toString();  ";
  protected final String TEXT_722 = NL + "        pstmt_";
  protected final String TEXT_723 = " = conn_";
  protected final String TEXT_724 = ".prepareStatement(delete_";
  protected final String TEXT_725 = ");";
  protected final String TEXT_726 = NL + "        String replace_";
  protected final String TEXT_727 = " = \"REPLACE INTO `\" + ";
  protected final String TEXT_728 = " + \"` (";
  protected final String TEXT_729 = ") VALUES (";
  protected final String TEXT_730 = ")\";" + NL + "        pstmt_";
  protected final String TEXT_731 = " = conn_";
  protected final String TEXT_732 = ".prepareStatement(replace_";
  protected final String TEXT_733 = ");";
  protected final String TEXT_734 = NL + "        String insertIgnore_";
  protected final String TEXT_735 = " = \"INSERT IGNORE INTO `\" + ";
  protected final String TEXT_736 = " + \"` (";
  protected final String TEXT_737 = ") VALUES (";
  protected final String TEXT_738 = ") ON DUPLICATE KEY UPDATE ";
  protected final String TEXT_739 = "\";" + NL + "        pstmt_";
  protected final String TEXT_740 = " = conn_";
  protected final String TEXT_741 = ".prepareStatement(insertIgnore_";
  protected final String TEXT_742 = ");";
  protected final String TEXT_743 = NL + "        String insert_";
  protected final String TEXT_744 = " = \"INSERT IGNORE INTO `\" + ";
  protected final String TEXT_745 = " + \"` (";
  protected final String TEXT_746 = ") VALUES (";
  protected final String TEXT_747 = ")\";";
  protected final String TEXT_748 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_749 = " = new StringBuffer(insert_";
  protected final String TEXT_750 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_751 = ".insert(insert_";
  protected final String TEXT_752 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_753 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_754 = " =insertStringBuffer_";
  protected final String TEXT_755 = ".toString(); ";
  protected final String TEXT_756 = "    " + NL + "        pstmt_";
  protected final String TEXT_757 = " = conn_";
  protected final String TEXT_758 = ".prepareStatement(insert_";
  protected final String TEXT_759 = ");";
  protected final String TEXT_760 = NL + "\t\t \tinsertSQLSplits_";
  protected final String TEXT_761 = " = insert_";
  protected final String TEXT_762 = ".split(\"\\\\?\");";
  protected final String TEXT_763 = NL + "\t\t\tupdate_";
  protected final String TEXT_764 = " += \" \";" + NL + "\t    \tupdateSQLSplits_";
  protected final String TEXT_765 = " = update_";
  protected final String TEXT_766 = ".split(\"\\\\?\");";
  protected final String TEXT_767 = NL + "\t\t\tupdate_";
  protected final String TEXT_768 = " += \" \";" + NL + "\t\t\tupdateSQLSplits_";
  protected final String TEXT_769 = " = update_";
  protected final String TEXT_770 = ".split(\"\\\\?\");" + NL + "\t\t\tinsertSQLSplits_";
  protected final String TEXT_771 = " = insert_";
  protected final String TEXT_772 = ".split(\"\\\\?\");";
  protected final String TEXT_773 = NL + "\t\t\tdelete_";
  protected final String TEXT_774 = " += \" \";" + NL + "\t\t   \tdeleteSQLSplits_";
  protected final String TEXT_775 = " = delete_";
  protected final String TEXT_776 = ".split(\"\\\\?\");";
  protected final String TEXT_777 = NL + "\t\t\treplace_";
  protected final String TEXT_778 = " += \" \";" + NL + "\t\t\treplaceSQLSplits_";
  protected final String TEXT_779 = " = replace_";
  protected final String TEXT_780 = ".split(\"\\\\?\");";
  protected final String TEXT_781 = NL + "\t\t\tinsertIgnore_";
  protected final String TEXT_782 = " += \" \";" + NL + "\t\t\tinsertIgnoreSQLSplits_";
  protected final String TEXT_783 = " = insertIgnore_";
  protected final String TEXT_784 = ".split(\"\\\\?\");";
  protected final String TEXT_785 = NL + "\t\t \tinsertSQLSplits_";
  protected final String TEXT_786 = " = insert_";
  protected final String TEXT_787 = ".split(\"\\\\?\");";
  protected final String TEXT_788 = NL + "        }";
  protected final String TEXT_789 = NL;
  protected final String TEXT_790 = NL + "                if(";
  protected final String TEXT_791 = ".";
  protected final String TEXT_792 = "==null){";
  protected final String TEXT_793 = NL + "                    ";
  protected final String TEXT_794 = ".setNull(counter";
  protected final String TEXT_795 = ",java.sql.Types.CHAR);";
  protected final String TEXT_796 = NL + "                if(";
  protected final String TEXT_797 = ".";
  protected final String TEXT_798 = "==null){";
  protected final String TEXT_799 = NL + "                    ";
  protected final String TEXT_800 = ".setNull(counter";
  protected final String TEXT_801 = ",java.sql.Types.DATE);";
  protected final String TEXT_802 = NL + "                if(";
  protected final String TEXT_803 = ".";
  protected final String TEXT_804 = "==null){";
  protected final String TEXT_805 = NL + "                    ";
  protected final String TEXT_806 = ".setNull(counter";
  protected final String TEXT_807 = ",java.sql.Types.ARRAY);";
  protected final String TEXT_808 = NL + "                if(";
  protected final String TEXT_809 = ".";
  protected final String TEXT_810 = "==null){";
  protected final String TEXT_811 = NL + "                    ";
  protected final String TEXT_812 = ".setNull(counter";
  protected final String TEXT_813 = ",java.sql.Types.INTEGER);";
  protected final String TEXT_814 = NL + "                if(";
  protected final String TEXT_815 = ".";
  protected final String TEXT_816 = "==null){";
  protected final String TEXT_817 = NL + "                    ";
  protected final String TEXT_818 = ".setNull(counter";
  protected final String TEXT_819 = ",java.sql.Types.VARCHAR);";
  protected final String TEXT_820 = NL + "                if(";
  protected final String TEXT_821 = ".";
  protected final String TEXT_822 = "==null){";
  protected final String TEXT_823 = NL + "                    ";
  protected final String TEXT_824 = ".setNull(counter";
  protected final String TEXT_825 = ",java.sql.Types.OTHER);";
  protected final String TEXT_826 = NL + "                if(";
  protected final String TEXT_827 = ".";
  protected final String TEXT_828 = "==null){";
  protected final String TEXT_829 = NL + "                    ";
  protected final String TEXT_830 = ".setNull(counter";
  protected final String TEXT_831 = ",java.sql.Types.BOOLEAN);";
  protected final String TEXT_832 = NL + "                if(";
  protected final String TEXT_833 = ".";
  protected final String TEXT_834 = "==null){";
  protected final String TEXT_835 = NL + "                    ";
  protected final String TEXT_836 = ".setNull(counter";
  protected final String TEXT_837 = ",java.sql.Types.DOUBLE);";
  protected final String TEXT_838 = NL + "                if(";
  protected final String TEXT_839 = ".";
  protected final String TEXT_840 = "==null){";
  protected final String TEXT_841 = NL + "                    ";
  protected final String TEXT_842 = ".setNull(counter";
  protected final String TEXT_843 = ",java.sql.Types.FLOAT);";
  protected final String TEXT_844 = NL + "                }else{";
  protected final String TEXT_845 = NL + "                    if(";
  protected final String TEXT_846 = ".";
  protected final String TEXT_847 = "==null){";
  protected final String TEXT_848 = NL + "                    if((\"null\").equals(String.valueOf(";
  protected final String TEXT_849 = ".";
  protected final String TEXT_850 = ").toLowerCase())){";
  protected final String TEXT_851 = NL + "                ";
  protected final String TEXT_852 = ".setNull(counter";
  protected final String TEXT_853 = ",java.sql.Types.CHAR);" + NL + "" + NL + "                }else if(";
  protected final String TEXT_854 = ".";
  protected final String TEXT_855 = " == '\\0'){" + NL;
  protected final String TEXT_856 = NL + "                    ";
  protected final String TEXT_857 = ".setString(counter";
  protected final String TEXT_858 = ",\"\");" + NL + "" + NL + "                }else{" + NL;
  protected final String TEXT_859 = NL + "                    ";
  protected final String TEXT_860 = ".setString(counter";
  protected final String TEXT_861 = ",String.valueOf(";
  protected final String TEXT_862 = ".";
  protected final String TEXT_863 = "));" + NL + "                }";
  protected final String TEXT_864 = NL + "                if(";
  protected final String TEXT_865 = ".";
  protected final String TEXT_866 = "!=null){" + NL + "                    // timestamp < min java date value (year 1) || timestamp > max mysql value (year 10000) => set 0000-00-00 as date in MySQL" + NL + "                    date_";
  protected final String TEXT_867 = " = ";
  protected final String TEXT_868 = ".";
  protected final String TEXT_869 = ".getTime();" + NL + "                    if (date_";
  protected final String TEXT_870 = " < year1_";
  protected final String TEXT_871 = " || date_";
  protected final String TEXT_872 = " >= year10000_";
  protected final String TEXT_873 = ") {";
  protected final String TEXT_874 = NL + "                        ";
  protected final String TEXT_875 = ".setString(counter";
  protected final String TEXT_876 = ", \"0000-00-00 00:00:00\");" + NL + "                    } else {";
  protected final String TEXT_877 = NL + "                        ";
  protected final String TEXT_878 = ".setTimestamp(counter";
  protected final String TEXT_879 = ", new java.sql.Timestamp(date_";
  protected final String TEXT_880 = "));" + NL + "                    }" + NL + "                }else{" + NL;
  protected final String TEXT_881 = NL + "                    ";
  protected final String TEXT_882 = ".setNull(counter";
  protected final String TEXT_883 = ",java.sql.Types.DATE);" + NL + "" + NL + "                }";
  protected final String TEXT_884 = NL + "                ";
  protected final String TEXT_885 = ".set";
  protected final String TEXT_886 = "(counter";
  protected final String TEXT_887 = ",";
  protected final String TEXT_888 = ".";
  protected final String TEXT_889 = ");";
  protected final String TEXT_890 = NL + NL + "                }" + NL;
  protected final String TEXT_891 = NL + "        query_";
  protected final String TEXT_892 = " = new StringBuffer(\"\");";
  protected final String TEXT_893 = NL + "                commitEvery_";
  protected final String TEXT_894 = " = buffersSize_";
  protected final String TEXT_895 = ";";
  protected final String TEXT_896 = NL + "                    batchSize_";
  protected final String TEXT_897 = " = buffersSize_";
  protected final String TEXT_898 = ";";
  protected final String TEXT_899 = NL;
  protected final String TEXT_900 = NL + "        whetherReject_";
  protected final String TEXT_901 = " = false;";
  protected final String TEXT_902 = NL + "                        int counter";
  protected final String TEXT_903 = " = rowCount";
  protected final String TEXT_904 = " * ";
  protected final String TEXT_905 = " + 1;";
  protected final String TEXT_906 = NL + "                            counter";
  protected final String TEXT_907 = "++;";
  protected final String TEXT_908 = NL + "                            int count_dyn_";
  protected final String TEXT_909 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_910 = ".";
  protected final String TEXT_911 = ", pstmt_";
  protected final String TEXT_912 = ", counter";
  protected final String TEXT_913 = "-1, \"";
  protected final String TEXT_914 = "\");" + NL + "                            counter";
  protected final String TEXT_915 = "+=count_dyn_";
  protected final String TEXT_916 = ";";
  protected final String TEXT_917 = NL + NL + "                    exInsertColValue";
  protected final String TEXT_918 = " = new BufferLine_";
  protected final String TEXT_919 = "(";
  protected final String TEXT_920 = NL + "                                ,";
  protected final String TEXT_921 = NL + "                            ";
  protected final String TEXT_922 = ".";
  protected final String TEXT_923 = NL + "                    , ";
  protected final String TEXT_924 = ".";
  protected final String TEXT_925 = NL + "                    );" + NL + "" + NL + "                    exInsertColValueList";
  protected final String TEXT_926 = ".add(exInsertColValue";
  protected final String TEXT_927 = ");" + NL + "" + NL + "                    rowCount";
  protected final String TEXT_928 = "++;";
  protected final String TEXT_929 = NL + "                nb_line_";
  protected final String TEXT_930 = "++;";
  protected final String TEXT_931 = NL + "                    if(rowCount";
  protected final String TEXT_932 = " == ";
  protected final String TEXT_933 = "){" + NL + "                        try{" + NL + "                            insertedCount_";
  protected final String TEXT_934 = " = insertedCount_";
  protected final String TEXT_935 = " + pstmt_";
  protected final String TEXT_936 = ".executeUpdate();" + NL + "                        }catch(java.lang.Exception e){";
  protected final String TEXT_937 = NL + "                             throw e;";
  protected final String TEXT_938 = NL + "                             System.err.println(e.getMessage());";
  protected final String TEXT_939 = NL + "                        }" + NL + "                        exInsertColValueList";
  protected final String TEXT_940 = ".clear();" + NL + "                        rowCount";
  protected final String TEXT_941 = " = 0;" + NL + "                        counter";
  protected final String TEXT_942 = "=1;" + NL + "                    }";
  protected final String TEXT_943 = NL + "                            ";
  protected final String TEXT_944 = NL + "                                query_";
  protected final String TEXT_945 = " = ";
  protected final String TEXT_946 = ";";
  protected final String TEXT_947 = NL + "                            routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_948 = ",";
  protected final String TEXT_949 = ".";
  protected final String TEXT_950 = ", ";
  protected final String TEXT_951 = ",insertSQLSplits_";
  protected final String TEXT_952 = ");";
  protected final String TEXT_953 = NL + "                            DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_954 = ".";
  protected final String TEXT_955 = ", pstmt_";
  protected final String TEXT_956 = ", ";
  protected final String TEXT_957 = ", \"";
  protected final String TEXT_958 = "\");";
  protected final String TEXT_959 = NL + "                        globalMap.put(\"";
  protected final String TEXT_960 = "_QUERY\", query_";
  protected final String TEXT_961 = ".toString().trim());";
  protected final String TEXT_962 = NL + "                    pstmt_";
  protected final String TEXT_963 = ".addBatch();" + NL + "                    nb_line_";
  protected final String TEXT_964 = "++;" + NL;
  protected final String TEXT_965 = NL + "                      batchSizeCounter_";
  protected final String TEXT_966 = "++;";
  protected final String TEXT_967 = NL + "                    try {" + NL + "                        nb_line_";
  protected final String TEXT_968 = "++;" + NL + "                        insertedCount_";
  protected final String TEXT_969 = " = insertedCount_";
  protected final String TEXT_970 = " + pstmt_";
  protected final String TEXT_971 = ".executeUpdate();";
  protected final String TEXT_972 = NL + "                    } catch(java.lang.Exception e) {" + NL + "                        whetherReject_";
  protected final String TEXT_973 = " = true;";
  protected final String TEXT_974 = NL + "                            throw(e);";
  protected final String TEXT_975 = NL + "                                ";
  protected final String TEXT_976 = " = new ";
  protected final String TEXT_977 = "Struct();";
  protected final String TEXT_978 = NL + "                                    ";
  protected final String TEXT_979 = ".";
  protected final String TEXT_980 = " = ";
  protected final String TEXT_981 = ".";
  protected final String TEXT_982 = ";";
  protected final String TEXT_983 = NL + "                                rejectedCount_";
  protected final String TEXT_984 = " =  rejectedCount_";
  protected final String TEXT_985 = "+ 1;";
  protected final String TEXT_986 = NL + "                                ";
  protected final String TEXT_987 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_988 = NL + "                                ";
  protected final String TEXT_989 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_990 = ";";
  protected final String TEXT_991 = NL + "                                System.err.print(e.getMessage());";
  protected final String TEXT_992 = NL + "                    }";
  protected final String TEXT_993 = NL + "                        ";
  protected final String TEXT_994 = NL + "                            query_";
  protected final String TEXT_995 = " = ";
  protected final String TEXT_996 = ";";
  protected final String TEXT_997 = NL + "                    routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_998 = ",";
  protected final String TEXT_999 = ".";
  protected final String TEXT_1000 = ", ";
  protected final String TEXT_1001 = ",insertSQLSplits_";
  protected final String TEXT_1002 = ");";
  protected final String TEXT_1003 = NL + "                        DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1004 = ".";
  protected final String TEXT_1005 = ", pstmt_";
  protected final String TEXT_1006 = ", ";
  protected final String TEXT_1007 = ", \"";
  protected final String TEXT_1008 = "\");";
  protected final String TEXT_1009 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1010 = "_QUERY\", query_";
  protected final String TEXT_1011 = ".toString().trim());";
  protected final String TEXT_1012 = NL + "                try {" + NL + "                    nb_line_";
  protected final String TEXT_1013 = "++;" + NL + "                    insertedCount_";
  protected final String TEXT_1014 = " = insertedCount_";
  protected final String TEXT_1015 = " + pstmt_";
  protected final String TEXT_1016 = ".executeUpdate();";
  protected final String TEXT_1017 = NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1018 = " = true;";
  protected final String TEXT_1019 = NL + "                        throw(e);";
  protected final String TEXT_1020 = NL + "                            ";
  protected final String TEXT_1021 = " = new ";
  protected final String TEXT_1022 = "Struct();";
  protected final String TEXT_1023 = NL + "                                ";
  protected final String TEXT_1024 = ".";
  protected final String TEXT_1025 = " = ";
  protected final String TEXT_1026 = ".";
  protected final String TEXT_1027 = ";";
  protected final String TEXT_1028 = NL + "                            rejectedCount_";
  protected final String TEXT_1029 = " =  rejectedCount_";
  protected final String TEXT_1030 = "+ 1;";
  protected final String TEXT_1031 = NL + "                            ";
  protected final String TEXT_1032 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1033 = NL + "                            ";
  protected final String TEXT_1034 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1035 = ";";
  protected final String TEXT_1036 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1037 = NL + "                }";
  protected final String TEXT_1038 = NL + "                    ";
  protected final String TEXT_1039 = NL + "                        query_";
  protected final String TEXT_1040 = " = ";
  protected final String TEXT_1041 = ";";
  protected final String TEXT_1042 = NL + "                        routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_1043 = ",";
  protected final String TEXT_1044 = ".";
  protected final String TEXT_1045 = ", ";
  protected final String TEXT_1046 = ",updateSQLSplits_";
  protected final String TEXT_1047 = ");";
  protected final String TEXT_1048 = NL + NL + "                    int count_";
  protected final String TEXT_1049 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1050 = ".";
  protected final String TEXT_1051 = ", pstmt_";
  protected final String TEXT_1052 = ", ";
  protected final String TEXT_1053 = ", \"";
  protected final String TEXT_1054 = "\");";
  protected final String TEXT_1055 = NL;
  protected final String TEXT_1056 = NL + "               ";
  protected final String TEXT_1057 = NL + "               ";
  protected final String TEXT_1058 = NL + "                            query_";
  protected final String TEXT_1059 = " = ";
  protected final String TEXT_1060 = ";";
  protected final String TEXT_1061 = NL + "                            query_";
  protected final String TEXT_1062 = " = ";
  protected final String TEXT_1063 = ";";
  protected final String TEXT_1064 = NL + "                    ";
  protected final String TEXT_1065 = NL + "                       query_";
  protected final String TEXT_1066 = " = ";
  protected final String TEXT_1067 = ";";
  protected final String TEXT_1068 = NL + "                       query_";
  protected final String TEXT_1069 = " = ";
  protected final String TEXT_1070 = ";";
  protected final String TEXT_1071 = NL + "                globalMap.put(\"";
  protected final String TEXT_1072 = "_QUERY\", query_";
  protected final String TEXT_1073 = ".toString().trim());";
  protected final String TEXT_1074 = NL;
  protected final String TEXT_1075 = NL + "            pstmt_";
  protected final String TEXT_1076 = ".addBatch();" + NL + "            nb_line_";
  protected final String TEXT_1077 = "++;" + NL;
  protected final String TEXT_1078 = NL + "              batchSizeCounter_";
  protected final String TEXT_1079 = "++;";
  protected final String TEXT_1080 = NL + "            try {" + NL + "                nb_line_";
  protected final String TEXT_1081 = "++;" + NL + "                updatedCount_";
  protected final String TEXT_1082 = " = updatedCount_";
  protected final String TEXT_1083 = " + pstmt_";
  protected final String TEXT_1084 = ".executeUpdate();";
  protected final String TEXT_1085 = NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1086 = " = true;";
  protected final String TEXT_1087 = NL + "                    throw(e);";
  protected final String TEXT_1088 = NL + "                        ";
  protected final String TEXT_1089 = " = new ";
  protected final String TEXT_1090 = "Struct();";
  protected final String TEXT_1091 = NL + "                            ";
  protected final String TEXT_1092 = ".";
  protected final String TEXT_1093 = " = ";
  protected final String TEXT_1094 = ".";
  protected final String TEXT_1095 = ";";
  protected final String TEXT_1096 = NL + "                        rejectedCount_";
  protected final String TEXT_1097 = " =  rejectedCount_";
  protected final String TEXT_1098 = "+ 1;";
  protected final String TEXT_1099 = NL + "                        ";
  protected final String TEXT_1100 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1101 = NL + "                        ";
  protected final String TEXT_1102 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1103 = ";";
  protected final String TEXT_1104 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1105 = NL + "            }";
  protected final String TEXT_1106 = NL + "                        ";
  protected final String TEXT_1107 = NL + "                    ";
  protected final String TEXT_1108 = NL + NL + "            java.sql.ResultSet rs_";
  protected final String TEXT_1109 = " = pstmt_";
  protected final String TEXT_1110 = ".executeQuery();" + NL + "            int checkCount_";
  protected final String TEXT_1111 = " = -1;" + NL + "            while(rs_";
  protected final String TEXT_1112 = ".next()) {" + NL + "                checkCount_";
  protected final String TEXT_1113 = " = rs_";
  protected final String TEXT_1114 = ".getInt(1);" + NL + "            }" + NL + "            if(checkCount_";
  protected final String TEXT_1115 = " > 0) {";
  protected final String TEXT_1116 = NL + "                        ";
  protected final String TEXT_1117 = NL + "                            query_";
  protected final String TEXT_1118 = " = ";
  protected final String TEXT_1119 = ";";
  protected final String TEXT_1120 = NL + "                            routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_1121 = ",";
  protected final String TEXT_1122 = ".";
  protected final String TEXT_1123 = ", ";
  protected final String TEXT_1124 = ",updateSQLSplits_";
  protected final String TEXT_1125 = ");";
  protected final String TEXT_1126 = NL + NL + "                        int count_";
  protected final String TEXT_1127 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1128 = ".";
  protected final String TEXT_1129 = ", pstmtUpdate_";
  protected final String TEXT_1130 = ", ";
  protected final String TEXT_1131 = ", \"";
  protected final String TEXT_1132 = "\");";
  protected final String TEXT_1133 = NL + "                    ";
  protected final String TEXT_1134 = NL + "                    ";
  protected final String TEXT_1135 = NL + "                                query_";
  protected final String TEXT_1136 = " = ";
  protected final String TEXT_1137 = ";";
  protected final String TEXT_1138 = NL + "                                query_";
  protected final String TEXT_1139 = " = ";
  protected final String TEXT_1140 = ";";
  protected final String TEXT_1141 = NL + "                        ";
  protected final String TEXT_1142 = NL + "                            query_";
  protected final String TEXT_1143 = " = ";
  protected final String TEXT_1144 = ";";
  protected final String TEXT_1145 = NL + "                            query_";
  protected final String TEXT_1146 = " = ";
  protected final String TEXT_1147 = ";";
  protected final String TEXT_1148 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1149 = "_QUERY\", query_";
  protected final String TEXT_1150 = ".toString().trim());";
  protected final String TEXT_1151 = NL + "                try {" + NL + "                    updatedCount_";
  protected final String TEXT_1152 = " = updatedCount_";
  protected final String TEXT_1153 = " + pstmtUpdate_";
  protected final String TEXT_1154 = ".executeUpdate();" + NL + "                    nb_line_";
  protected final String TEXT_1155 = "++;";
  protected final String TEXT_1156 = NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1157 = " = true;";
  protected final String TEXT_1158 = NL + "                        throw(e);";
  protected final String TEXT_1159 = NL + "                        nb_line_";
  protected final String TEXT_1160 = "++;";
  protected final String TEXT_1161 = NL + "                        ";
  protected final String TEXT_1162 = " = new ";
  protected final String TEXT_1163 = "Struct();";
  protected final String TEXT_1164 = NL + "                                ";
  protected final String TEXT_1165 = ".";
  protected final String TEXT_1166 = " = ";
  protected final String TEXT_1167 = ".";
  protected final String TEXT_1168 = ";";
  protected final String TEXT_1169 = NL + "                            rejectedCount_";
  protected final String TEXT_1170 = " =  rejectedCount_";
  protected final String TEXT_1171 = "+ 1;";
  protected final String TEXT_1172 = NL + "                            ";
  protected final String TEXT_1173 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1174 = NL + "                            ";
  protected final String TEXT_1175 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1176 = ";";
  protected final String TEXT_1177 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1178 = NL + "                }" + NL + "            } else {";
  protected final String TEXT_1179 = NL + "                        ";
  protected final String TEXT_1180 = NL + "                            query_";
  protected final String TEXT_1181 = " = ";
  protected final String TEXT_1182 = ";";
  protected final String TEXT_1183 = NL + "                        routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_1184 = ",";
  protected final String TEXT_1185 = ".";
  protected final String TEXT_1186 = ", ";
  protected final String TEXT_1187 = ",insertSQLSplits_";
  protected final String TEXT_1188 = ");";
  protected final String TEXT_1189 = NL + "                        DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1190 = ".";
  protected final String TEXT_1191 = ", pstmtInsert_";
  protected final String TEXT_1192 = ", ";
  protected final String TEXT_1193 = ", \"";
  protected final String TEXT_1194 = "\");";
  protected final String TEXT_1195 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1196 = "_QUERY\", query_";
  protected final String TEXT_1197 = ".toString().trim());";
  protected final String TEXT_1198 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_1199 = " = insertedCount_";
  protected final String TEXT_1200 = " + pstmtInsert_";
  protected final String TEXT_1201 = ".executeUpdate();" + NL + "                    nb_line_";
  protected final String TEXT_1202 = "++;";
  protected final String TEXT_1203 = NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1204 = " = true;";
  protected final String TEXT_1205 = NL + "                        throw(e);";
  protected final String TEXT_1206 = NL + "                        nb_line_";
  protected final String TEXT_1207 = "++;";
  protected final String TEXT_1208 = NL + "                        ";
  protected final String TEXT_1209 = " = new ";
  protected final String TEXT_1210 = "Struct();";
  protected final String TEXT_1211 = NL + "                                ";
  protected final String TEXT_1212 = ".";
  protected final String TEXT_1213 = " = ";
  protected final String TEXT_1214 = ".";
  protected final String TEXT_1215 = ";";
  protected final String TEXT_1216 = NL + "                            rejectedCount_";
  protected final String TEXT_1217 = " =  rejectedCount_";
  protected final String TEXT_1218 = "+ 1;";
  protected final String TEXT_1219 = NL + "                            ";
  protected final String TEXT_1220 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1221 = NL + "                            ";
  protected final String TEXT_1222 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1223 = ";";
  protected final String TEXT_1224 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1225 = NL + "                }" + NL + "            }";
  protected final String TEXT_1226 = NL + "            int updateFlag_";
  protected final String TEXT_1227 = "=0;";
  protected final String TEXT_1228 = NL + "                    ";
  protected final String TEXT_1229 = NL + "                        query_";
  protected final String TEXT_1230 = " = ";
  protected final String TEXT_1231 = ";";
  protected final String TEXT_1232 = NL + "                        routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_1233 = ",";
  protected final String TEXT_1234 = ".";
  protected final String TEXT_1235 = ", ";
  protected final String TEXT_1236 = ",updateSQLSplits_";
  protected final String TEXT_1237 = ");";
  protected final String TEXT_1238 = NL + NL + "                    int count_";
  protected final String TEXT_1239 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1240 = ".";
  protected final String TEXT_1241 = ", pstmtUpdate_";
  protected final String TEXT_1242 = ", ";
  protected final String TEXT_1243 = ", \"";
  protected final String TEXT_1244 = "\");";
  protected final String TEXT_1245 = NL + "                        ";
  protected final String TEXT_1246 = NL + "                        ";
  protected final String TEXT_1247 = NL + "                        query_";
  protected final String TEXT_1248 = " = ";
  protected final String TEXT_1249 = ";";
  protected final String TEXT_1250 = NL + "                        query_";
  protected final String TEXT_1251 = " = ";
  protected final String TEXT_1252 = ";";
  protected final String TEXT_1253 = NL;
  protected final String TEXT_1254 = NL + "                    ";
  protected final String TEXT_1255 = NL + "                        query_";
  protected final String TEXT_1256 = " = ";
  protected final String TEXT_1257 = ";";
  protected final String TEXT_1258 = NL + "                        query_";
  protected final String TEXT_1259 = " = ";
  protected final String TEXT_1260 = ";";
  protected final String TEXT_1261 = NL + "                globalMap.put(\"";
  protected final String TEXT_1262 = "_QUERY\", query_";
  protected final String TEXT_1263 = ".toString().trim());";
  protected final String TEXT_1264 = NL + NL + "            try {" + NL + "                updateFlag_";
  protected final String TEXT_1265 = "=pstmtUpdate_";
  protected final String TEXT_1266 = ".executeUpdate();" + NL + "                updatedCount_";
  protected final String TEXT_1267 = " = updatedCount_";
  protected final String TEXT_1268 = "+updateFlag_";
  protected final String TEXT_1269 = ";" + NL + "" + NL + "            if(updateFlag_";
  protected final String TEXT_1270 = " == 0) {" + NL;
  protected final String TEXT_1271 = NL + "                query_";
  protected final String TEXT_1272 = " = new StringBuffer(\"\");";
  protected final String TEXT_1273 = NL + "                        ";
  protected final String TEXT_1274 = NL + "                            query_";
  protected final String TEXT_1275 = " = ";
  protected final String TEXT_1276 = ";";
  protected final String TEXT_1277 = NL + "                            routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_1278 = ",";
  protected final String TEXT_1279 = ".";
  protected final String TEXT_1280 = ", ";
  protected final String TEXT_1281 = ",insertSQLSplits_";
  protected final String TEXT_1282 = ");";
  protected final String TEXT_1283 = NL + "                        DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1284 = ".";
  protected final String TEXT_1285 = ", pstmtInsert_";
  protected final String TEXT_1286 = ", ";
  protected final String TEXT_1287 = ", \"";
  protected final String TEXT_1288 = "\");";
  protected final String TEXT_1289 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1290 = "_QUERY\", query_";
  protected final String TEXT_1291 = ".toString().trim());";
  protected final String TEXT_1292 = NL + "                    insertedCount_";
  protected final String TEXT_1293 = " = insertedCount_";
  protected final String TEXT_1294 = " + pstmtInsert_";
  protected final String TEXT_1295 = ".executeUpdate();" + NL + "                    nb_line_";
  protected final String TEXT_1296 = "++;";
  protected final String TEXT_1297 = NL + "                }else{" + NL + "                    nb_line_";
  protected final String TEXT_1298 = "++;";
  protected final String TEXT_1299 = NL + "             }" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1300 = " = true;";
  protected final String TEXT_1301 = NL + "                        throw(e);";
  protected final String TEXT_1302 = NL + "                        nb_line_";
  protected final String TEXT_1303 = "++;";
  protected final String TEXT_1304 = NL + "                        ";
  protected final String TEXT_1305 = " = new ";
  protected final String TEXT_1306 = "Struct();";
  protected final String TEXT_1307 = NL + "                                ";
  protected final String TEXT_1308 = ".";
  protected final String TEXT_1309 = " = ";
  protected final String TEXT_1310 = ".";
  protected final String TEXT_1311 = ";";
  protected final String TEXT_1312 = NL + "                            rejectedCount_";
  protected final String TEXT_1313 = " =  rejectedCount_";
  protected final String TEXT_1314 = "+ 1;";
  protected final String TEXT_1315 = NL + "                            ";
  protected final String TEXT_1316 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1317 = NL + "                            ";
  protected final String TEXT_1318 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1319 = ";";
  protected final String TEXT_1320 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1321 = NL + "                }";
  protected final String TEXT_1322 = NL + "                        ";
  protected final String TEXT_1323 = NL + "                            query_";
  protected final String TEXT_1324 = " = ";
  protected final String TEXT_1325 = ";";
  protected final String TEXT_1326 = NL + "                    ";
  protected final String TEXT_1327 = NL + "                        query_";
  protected final String TEXT_1328 = " = ";
  protected final String TEXT_1329 = ";";
  protected final String TEXT_1330 = NL + "                globalMap.put(\"";
  protected final String TEXT_1331 = "_QUERY\", query_";
  protected final String TEXT_1332 = ".toString().trim());";
  protected final String TEXT_1333 = NL + "            pstmt_";
  protected final String TEXT_1334 = ".addBatch();" + NL + "            nb_line_";
  protected final String TEXT_1335 = "++;";
  protected final String TEXT_1336 = NL + "              batchSizeCounter_";
  protected final String TEXT_1337 = "++;";
  protected final String TEXT_1338 = NL + "            try {" + NL + "                deletedCount_";
  protected final String TEXT_1339 = " = deletedCount_";
  protected final String TEXT_1340 = " + pstmt_";
  protected final String TEXT_1341 = ".executeUpdate();" + NL + "                nb_line_";
  protected final String TEXT_1342 = "++;";
  protected final String TEXT_1343 = NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1344 = " = true;";
  protected final String TEXT_1345 = NL + "                    throw(e);";
  protected final String TEXT_1346 = NL + "                    nb_line_";
  protected final String TEXT_1347 = "++;";
  protected final String TEXT_1348 = NL + "                        ";
  protected final String TEXT_1349 = " = new ";
  protected final String TEXT_1350 = "Struct();";
  protected final String TEXT_1351 = NL + "                            ";
  protected final String TEXT_1352 = ".";
  protected final String TEXT_1353 = " = ";
  protected final String TEXT_1354 = ".";
  protected final String TEXT_1355 = ";" + NL;
  protected final String TEXT_1356 = NL + "                        rejectedCount_";
  protected final String TEXT_1357 = " =  rejectedCount_";
  protected final String TEXT_1358 = "+ 1;";
  protected final String TEXT_1359 = NL + "                        ";
  protected final String TEXT_1360 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1361 = NL + "                        ";
  protected final String TEXT_1362 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1363 = ";" + NL;
  protected final String TEXT_1364 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1365 = NL + "            }";
  protected final String TEXT_1366 = NL + "                    ";
  protected final String TEXT_1367 = NL + "                        query_";
  protected final String TEXT_1368 = " = ";
  protected final String TEXT_1369 = ";";
  protected final String TEXT_1370 = NL + "                globalMap.put(\"";
  protected final String TEXT_1371 = "_QUERY\", query_";
  protected final String TEXT_1372 = ".toString().trim());";
  protected final String TEXT_1373 = NL + "            int replaceCount_";
  protected final String TEXT_1374 = " = 0;" + NL + "            try {" + NL + "                replaceCount_";
  protected final String TEXT_1375 = " = pstmt_";
  protected final String TEXT_1376 = ".executeUpdate();";
  protected final String TEXT_1377 = NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1378 = " = true;";
  protected final String TEXT_1379 = NL + "                    throw(e);";
  protected final String TEXT_1380 = NL + "                        ";
  protected final String TEXT_1381 = " = new ";
  protected final String TEXT_1382 = "Struct();";
  protected final String TEXT_1383 = NL + "                            ";
  protected final String TEXT_1384 = ".";
  protected final String TEXT_1385 = " = ";
  protected final String TEXT_1386 = ".";
  protected final String TEXT_1387 = ";";
  protected final String TEXT_1388 = NL + "                        rejectedCount_";
  protected final String TEXT_1389 = " =  rejectedCount_";
  protected final String TEXT_1390 = "+ 1;";
  protected final String TEXT_1391 = NL + "                        ";
  protected final String TEXT_1392 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1393 = NL + "                        ";
  protected final String TEXT_1394 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1395 = ";";
  protected final String TEXT_1396 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1397 = NL + "            }" + NL + "            if(replaceCount_";
  protected final String TEXT_1398 = " == 1) {" + NL + "                insertedCount_";
  protected final String TEXT_1399 = " += replaceCount_";
  protected final String TEXT_1400 = ";" + NL + "            } else {" + NL + "                insertedCount_";
  protected final String TEXT_1401 = " += 1;" + NL + "                deletedCount_";
  protected final String TEXT_1402 = " += replaceCount_";
  protected final String TEXT_1403 = " - 1;" + NL + "            }";
  protected final String TEXT_1404 = NL + "                    ";
  protected final String TEXT_1405 = NL + "                        query_";
  protected final String TEXT_1406 = " = ";
  protected final String TEXT_1407 = ";";
  protected final String TEXT_1408 = NL + "                    ";
  protected final String TEXT_1409 = NL + "                        query_";
  protected final String TEXT_1410 = " = ";
  protected final String TEXT_1411 = ";";
  protected final String TEXT_1412 = NL + "                globalMap.put(\"";
  protected final String TEXT_1413 = "_QUERY\", query_";
  protected final String TEXT_1414 = ".toString().trim());";
  protected final String TEXT_1415 = NL + "            int count_on_duplicate_key_";
  protected final String TEXT_1416 = " = 0;" + NL + "            try {" + NL + "                count_on_duplicate_key_";
  protected final String TEXT_1417 = " = pstmt_";
  protected final String TEXT_1418 = ".executeUpdate();";
  protected final String TEXT_1419 = NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1420 = " = true;";
  protected final String TEXT_1421 = NL + "                    throw(e);";
  protected final String TEXT_1422 = NL + "                        ";
  protected final String TEXT_1423 = " = new ";
  protected final String TEXT_1424 = "Struct();";
  protected final String TEXT_1425 = NL + "                            ";
  protected final String TEXT_1426 = ".";
  protected final String TEXT_1427 = " = ";
  protected final String TEXT_1428 = ".";
  protected final String TEXT_1429 = ";";
  protected final String TEXT_1430 = NL + "                        rejectedCount_";
  protected final String TEXT_1431 = " =  rejectedCount_";
  protected final String TEXT_1432 = "+ 1;";
  protected final String TEXT_1433 = NL + "                        ";
  protected final String TEXT_1434 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1435 = NL + "                        ";
  protected final String TEXT_1436 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1437 = ";";
  protected final String TEXT_1438 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1439 = NL + "            }" + NL + "            if(count_on_duplicate_key_";
  protected final String TEXT_1440 = " == 1) {" + NL + "                insertedCount_";
  protected final String TEXT_1441 = " += count_on_duplicate_key_";
  protected final String TEXT_1442 = ";" + NL + "            } else {" + NL + "                insertedCount_";
  protected final String TEXT_1443 = " += 1;" + NL + "                updatedCount_";
  protected final String TEXT_1444 = " += count_on_duplicate_key_";
  protected final String TEXT_1445 = " - 1;" + NL + "            }";
  protected final String TEXT_1446 = NL + "                        ";
  protected final String TEXT_1447 = NL + "                            query_";
  protected final String TEXT_1448 = " = ";
  protected final String TEXT_1449 = ";";
  protected final String TEXT_1450 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1451 = "_QUERY\", query_";
  protected final String TEXT_1452 = ".toString().trim());";
  protected final String TEXT_1453 = NL + "                try {" + NL + "                    nb_line_";
  protected final String TEXT_1454 = "++;" + NL + "                    insertedCount_";
  protected final String TEXT_1455 = " = insertedCount_";
  protected final String TEXT_1456 = " + pstmt_";
  protected final String TEXT_1457 = ".executeUpdate();";
  protected final String TEXT_1458 = NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1459 = " = true;";
  protected final String TEXT_1460 = NL + "                        throw(e);";
  protected final String TEXT_1461 = NL + "                            ";
  protected final String TEXT_1462 = " = new ";
  protected final String TEXT_1463 = "Struct();";
  protected final String TEXT_1464 = NL + "                                ";
  protected final String TEXT_1465 = ".";
  protected final String TEXT_1466 = " = ";
  protected final String TEXT_1467 = ".";
  protected final String TEXT_1468 = ";";
  protected final String TEXT_1469 = NL + "                            rejectedCount_";
  protected final String TEXT_1470 = " =  rejectedCount_";
  protected final String TEXT_1471 = "+ 1;";
  protected final String TEXT_1472 = NL + "                            ";
  protected final String TEXT_1473 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1474 = NL + "                            ";
  protected final String TEXT_1475 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1476 = ";";
  protected final String TEXT_1477 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1478 = NL + "                }";
  protected final String TEXT_1479 = NL + "            if(!whetherReject_";
  protected final String TEXT_1480 = ") {";
  protected final String TEXT_1481 = NL + "                            ";
  protected final String TEXT_1482 = " = new ";
  protected final String TEXT_1483 = "Struct();";
  protected final String TEXT_1484 = NL + "                                ";
  protected final String TEXT_1485 = ".";
  protected final String TEXT_1486 = " = ";
  protected final String TEXT_1487 = ".";
  protected final String TEXT_1488 = ";";
  protected final String TEXT_1489 = NL + "            }";
  protected final String TEXT_1490 = NL + "                if ( batchSize_";
  protected final String TEXT_1491 = " <= batchSizeCounter_";
  protected final String TEXT_1492 = ") {";
  protected final String TEXT_1493 = NL + "                try {" + NL + "                        int countSum_";
  protected final String TEXT_1494 = " = 0;";
  protected final String TEXT_1495 = NL + "                        for(int countEach_";
  protected final String TEXT_1496 = ": pstmt_";
  protected final String TEXT_1497 = ".executeBatch()) {" + NL + "                            countSum_";
  protected final String TEXT_1498 = " += (countEach_";
  protected final String TEXT_1499 = " < 0 ? 0 : 1);" + NL + "                        }";
  protected final String TEXT_1500 = NL + "                        insertedCount_";
  protected final String TEXT_1501 = " += countSum_";
  protected final String TEXT_1502 = ";";
  protected final String TEXT_1503 = NL + "                }catch (java.sql.BatchUpdateException e){";
  protected final String TEXT_1504 = NL + "                        throw(e);";
  protected final String TEXT_1505 = NL + "                    int countSum_";
  protected final String TEXT_1506 = " = 0;" + NL + "                    for(int countEach_";
  protected final String TEXT_1507 = ": e.getUpdateCounts()) {" + NL + "                        countSum_";
  protected final String TEXT_1508 = " += (countEach_";
  protected final String TEXT_1509 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1510 = ");" + NL + "                    }";
  protected final String TEXT_1511 = NL + "                    insertedCount_";
  protected final String TEXT_1512 = " += countSum_";
  protected final String TEXT_1513 = ";";
  protected final String TEXT_1514 = NL + "                    System.err.println(e.getMessage());";
  protected final String TEXT_1515 = NL + "                }";
  protected final String TEXT_1516 = NL + NL + "                batchSizeCounter_";
  protected final String TEXT_1517 = " = 0;" + NL + "            }";
  protected final String TEXT_1518 = NL + "                if ( batchSize_";
  protected final String TEXT_1519 = " <= batchSizeCounter_";
  protected final String TEXT_1520 = ") {";
  protected final String TEXT_1521 = NL + "                try {" + NL + "                        int countSum_";
  protected final String TEXT_1522 = " = 0;";
  protected final String TEXT_1523 = NL + "                        for(int countEach_";
  protected final String TEXT_1524 = ": pstmt_";
  protected final String TEXT_1525 = ".executeBatch()) {" + NL + "                            countSum_";
  protected final String TEXT_1526 = " += (countEach_";
  protected final String TEXT_1527 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1528 = ");" + NL + "                        }";
  protected final String TEXT_1529 = NL + "                        updatedCount_";
  protected final String TEXT_1530 = " += countSum_";
  protected final String TEXT_1531 = ";";
  protected final String TEXT_1532 = NL + "                        deletedCount_";
  protected final String TEXT_1533 = " += countSum_";
  protected final String TEXT_1534 = ";";
  protected final String TEXT_1535 = NL + "                        batchSizeCounter_";
  protected final String TEXT_1536 = " = 0;" + NL + "                }catch (java.sql.BatchUpdateException e){";
  protected final String TEXT_1537 = NL + "                        throw(e);";
  protected final String TEXT_1538 = NL + "                    int countSum_";
  protected final String TEXT_1539 = " = 0;" + NL + "                    for(int countEach_";
  protected final String TEXT_1540 = ": e.getUpdateCounts()) {" + NL + "                        countSum_";
  protected final String TEXT_1541 = " += (countEach_";
  protected final String TEXT_1542 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1543 = ");" + NL + "                    }";
  protected final String TEXT_1544 = NL + "                    updatedCount_";
  protected final String TEXT_1545 = " += countSum_";
  protected final String TEXT_1546 = ";";
  protected final String TEXT_1547 = NL + "                    deletedCount_";
  protected final String TEXT_1548 = " += countSum_";
  protected final String TEXT_1549 = ";";
  protected final String TEXT_1550 = NL + "                    System.err.println(e.getMessage());";
  protected final String TEXT_1551 = NL + "                }";
  protected final String TEXT_1552 = NL + NL + NL + NL + "                }";
  protected final String TEXT_1553 = NL + "                commitCounter_";
  protected final String TEXT_1554 = "++;" + NL + "" + NL + "                if(commitEvery_";
  protected final String TEXT_1555 = " <= commitCounter_";
  protected final String TEXT_1556 = ") {" + NL;
  protected final String TEXT_1557 = NL + "                try {" + NL + "                        int countSum_";
  protected final String TEXT_1558 = " = 0;";
  protected final String TEXT_1559 = NL + "                        for(int countEach_";
  protected final String TEXT_1560 = ": pstmt_";
  protected final String TEXT_1561 = ".executeBatch()) {" + NL + "                            countSum_";
  protected final String TEXT_1562 = " += (countEach_";
  protected final String TEXT_1563 = " < 0 ? 0 : ";
  protected final String TEXT_1564 = ");" + NL + "                        }";
  protected final String TEXT_1565 = NL + "                        insertedCount_";
  protected final String TEXT_1566 = " += countSum_";
  protected final String TEXT_1567 = ";";
  protected final String TEXT_1568 = NL + "                        updatedCount_";
  protected final String TEXT_1569 = " += countSum_";
  protected final String TEXT_1570 = ";";
  protected final String TEXT_1571 = NL + "                        deletedCount_";
  protected final String TEXT_1572 = " += countSum_";
  protected final String TEXT_1573 = ";";
  protected final String TEXT_1574 = NL + "                }catch (java.sql.BatchUpdateException e){";
  protected final String TEXT_1575 = NL + "                        throw(e);";
  protected final String TEXT_1576 = NL + "                    int countSum_";
  protected final String TEXT_1577 = " = 0;" + NL + "                    for(int countEach_";
  protected final String TEXT_1578 = ": e.getUpdateCounts()) {" + NL + "                        countSum_";
  protected final String TEXT_1579 = " += (countEach_";
  protected final String TEXT_1580 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1581 = ");" + NL + "                    }";
  protected final String TEXT_1582 = NL + "                    insertedCount_";
  protected final String TEXT_1583 = " += countSum_";
  protected final String TEXT_1584 = ";";
  protected final String TEXT_1585 = NL + "                    updatedCount_";
  protected final String TEXT_1586 = " += countSum_";
  protected final String TEXT_1587 = ";";
  protected final String TEXT_1588 = NL + "                    deletedCount_";
  protected final String TEXT_1589 = " += countSum_";
  protected final String TEXT_1590 = ";";
  protected final String TEXT_1591 = NL + "                    System.err.println(e.getMessage());";
  protected final String TEXT_1592 = NL + NL + "                }";
  protected final String TEXT_1593 = NL + "                    conn_";
  protected final String TEXT_1594 = ".commit();";
  protected final String TEXT_1595 = NL + "                    commitCounter_";
  protected final String TEXT_1596 = "=0;" + NL + "" + NL + "                }" + NL;
  protected final String TEXT_1597 = NL;

    public static final String INSERT_COLUMN_NAME = "insertColName";
    public static final String INSERT_VALUE_STMT = "insertValueStmt";
    public static final String UPDATE_SET_STMT = "updateSetStmt";
    public static final String UPDATE_WHERE_STMT = "updateWhereStmt";
    public static final String DELETE_WHERE_STMT = "deleteWhereStmt";
    public static final String FIRST_UPDATE_KEY = "firstUpdateKeyColumn";
    public static final String FIRST_DELETE_KEY = "firstDeleteKeyColumn";
    public static final String FIRST_INSERT_COLUMN = "firstInsertColumn";
    public static final String FIRST_UPDATE_COLUMN = "firstUpdateColumn";
    public static final int NORMAL_TYPE = 0;
    public static final int INSERT_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final String ACCESS = "access_id";
    public static final String AS400 = "as400_id";
    public static final String DB2 = "ibmdb2_id";
    public static final String FIREBIRD = "firebird_id";
    public static final String GREENPLUM = "greenplum_id";
    public static final String HSQLDB = "hsqldb_id";
    public static final String HIVE = "hive_id";
    public static final String INFORMIX = "informix_id";
    public static final String INGRES = "ingres_id";
    public static final String VECTORWISE = "vectorwise_id";
    public static final String INTERBASE = "interbase_id";
    public static final String JAVADB = "javadb_id";
    public static final String MAXDB = "maxdb_id";
    public static final String MSSQL = "id_MSSQL";
    public static final String MYSQL = "mysql_id";
    public static final String NETEZZA = "netezza_id";
    public static final String ORACLE = "oracle_id";
    public static final String PARACCEL = "paraccel_id";
    public static final String POSTGRESQL = "postgres_id";
    public static final String REDSHIFT = "redshift_id";
    public static final String POSTGREPLUS = "postgresplus_id";
    public static final String SQLITE = "sqlite_id";
    public static final String SYBASE = "sybase_id";
    public static final String TERADATA = "teradata_id";
    public static final String VERTICA = "vertica_id";
    public static final String ODBC = "MSODBC";
    public static final String JDBC = "JDBC";
    public static final String EXASOL = "Exasol_id";
    public static final String SAPHANA = "saphana_id";
    private static Map<String, Manager> managerMap = new HashMap<String, Manager>();
    public class Column {
        IMetadataColumn column;
        String name;
        String dataType;
        String operator;
        String columnName;
        String sqlStmt;
        String value;
        boolean addCol;
        boolean isKey;
        boolean isAutoIncrement;
        int startValue;
        int step;
        boolean isUpdateKey;
        boolean isDeleteKey;
        boolean insertable = true;
        boolean updatable = true;
        List<Column> replacement = new ArrayList<Column>();
        
        boolean isDynamic = false;
        
        public Column(String colName, String sqlStmt, boolean addCol) {
            this.column = null;
            this.name = colName;
            this.columnName = colName;
            this.sqlStmt = sqlStmt;
            this.value = "?";
            this.addCol = addCol;
        }
        public Column(IMetadataColumn column) {
            this.column = column;
            this.name = column.getLabel();
            this.sqlStmt = "?";
            this.value = "?";
            this.addCol = false;
            this.columnName = column.getOriginalDbColumnName();
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            this(column, isKey, useFieldOptions, fieldOption);
            if(isSpecifyIdentityKey) {
                if(column.getLabel().equals(identityKey)) {
                    isAutoIncrement = false;
                    this.startValue = startValue;
                    this.step = step;
                }
            }
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption) {
            this(column);
            this.isKey = isKey;
            if(useFieldOptions) {
                this.isUpdateKey = fieldOption.get("UPDATE_KEY").equals("true");
                this.isDeleteKey = fieldOption.get("DELETE_KEY").equals("true");
                this.insertable = fieldOption.get("INSERTABLE").equals("true");
                this.updatable = fieldOption.get("UPDATABLE").equals("true");                
            } else {
                this.insertable = true;
                if (isKey) {
                    this.isUpdateKey = true;
                    this.isDeleteKey = true;
                    this.updatable = false;
                }
                else {
                    this.isUpdateKey = false;
                    this.isDeleteKey = false;
                    this.updatable = true;
                }                
            }
        }
        public boolean isReplaced() {
            return replacement.size() > 0;
        }
        public void replace(Column column) {
            this.replacement.add(column);
        }
        public List<Column> getReplacement() {
            return this.replacement;
        }
        public void setColumn(IMetadataColumn column) {
            this.column = column;
        }
        public IMetadataColumn getColumn() {
            return this.column;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
        public String getColumnName() {
            return this.columnName;
        }
        public void setIsAddCol(boolean isadd) {
            this.addCol = isadd;
        }
        public boolean isAddCol() {
            return this.addCol;
        }
        public void setSqlStmt(String sql) {
            this.sqlStmt = sql;
        }
        public String getSqlStmt() {
            if(this.getColumn()!=null) {
                if (this.getColumn().getTalendType().equals("id_Geometry")) {
                    
                    if ("MDSYS.SDO_GEOMETRY".equalsIgnoreCase(this.getColumn().getType())) {
                        return "?";
                    } else {
                        return "GeomFromText(?, ?)";    // For PostGIS
                    }
                } else {
                    return this.sqlStmt;
                }
            } else {
                return this.sqlStmt;
            }
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }
        public String getDataType() {
            return dataType;
        }
        public void setOperator(String operator) {
            this.operator = operator;
        }
        public String getOperator() {
            return operator;
        }
        public boolean isAutoIncrement() {
            return this.isAutoIncrement;
        }
        public void setAutoIncrement(boolean isAutoIncrement) {
            this.isAutoIncrement = isAutoIncrement;
        }
        public int getStartValue() {
            return this.startValue;
        }
        public void setStartValue(int startValue) {
            this.startValue = startValue;
        }
        public int getStep() {
            return this.step;
        }
        public void setStep(int step) {
            this.step = step;
        }
        public boolean isKey() {
            return this.isKey;
        }
        public void setKey(boolean isKey) {
            this.isKey = isKey;
        }
        public boolean isUpdateKey() {
            return this.isUpdateKey;
        }
        public void setUpdateKey(boolean isUpdateKey) {
            this.isUpdateKey = isUpdateKey;
        }
        public boolean isDeleteKey() {
            return this.isDeleteKey;
        }
        public void setDeleteKey(boolean isDeleteKey) {
            this.isDeleteKey = isDeleteKey;
        }
        public boolean isInsertable() {
            return this.insertable;
        }
        public void setInsertable(boolean insertable) {
            this.insertable = insertable;
        }
        public boolean isUpdatable() {
            return this.updatable;
        }
        public void setUpdatable(boolean updatable) {
            this.updatable = updatable;
        }
        
        public boolean isDynamic() {
            return isDynamic;
        }
        
        public void setDynamic(boolean isDynamic) {
            this.isDynamic = isDynamic;
        }
    }
        
    public Column getColumn(IMetadataColumn column) {
        return new Column(column);
    }

    public Column getColumn(String colName, String sqlStmt, boolean addCol) {
        return new Column(colName, sqlStmt, addCol);
    }
    
    public Column getColumn(IMetadataColumn column, boolean isKey, boolean useFieldsOptions, Map<String, String> fieldOption) {
        return new Column(column, isKey, useFieldsOptions, fieldOption);
    }

    public abstract class Manager {
        
        protected INode node;// add the Node, it will be more convenient
        public void setNode(INode node) {
           this.node = node;
        }
        
        protected String cid;        
        protected abstract String getDBMSId();
        protected abstract String getLProtectedChar();
        protected abstract String getRProtectedChar();        
        public Manager() {}
        public Manager(String cid) {
            this.cid = cid;
        }
      protected  String getLProtectedChar(String columName) {
          return getLProtectedChar();
      }
      protected  String getRProtectedChar(String columName) {
          return getRProtectedChar();        
      }
      protected boolean contaionsSpaces(String columnName) {
          if (columnName != null) {
              if (columnName.startsWith("\" + ") && columnName.endsWith(" + \"")) {
                  return false;
              }
              
              if (columnName.contains(" ")) {
                  return true;
              }
              // minus are also a problem
              if (columnName.contains("-")) {
                  return true;
              }
          }
          return false;
      }

        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(1) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }
        public String getDeleteTableSQL() {
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append("DELETE FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return deleteTableSQL.toString();
        }
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return truncateTableSQL.toString();
        }
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE " + getRProtectedChar());
            return truncate_reuse_stroage_TableSQL.toString();
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else if("oracle_id".equalsIgnoreCase(getDBMSId()) && dataType.matches("TIMESTAMP WITH TIME ZONE")){
                            createSQL.append("TIMESTAMP("+length+") WITH TIME ZONE");
                        }else{                            
                            createSQL.append(dataType);
                        }
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
                                String columnStr = getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() );
                                int index = pkList.indexOf(columnStr);
                                if(index !=-1){
                                    for (int i=index;i>0;i--) {
                                        pkList.set(i, pkList.get(i-1));
                                    }
                                    pkList.set(0, columnStr);
                                }
                            }
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        protected String getAutoIncrement(int startValue, int step) {
            if("sybase_id".equalsIgnoreCase(getDBMSId())){
                return " IDENTITY NOT NULL";
            } else if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
                return " AUTO_INCREMENT";
            } else if("ibmdb2_id".equalsIgnoreCase(getDBMSId())){
                return " Generated by default AS IDENTITY(START WITH "+startValue+", INCREMENT BY "+step+", NO CACHE )";
            } else if("teradata_id".equalsIgnoreCase(getDBMSId())){
                return " generated by default as identity (start with " + startValue + " increment by " + step + " no cycle) not null";
            }else {
                return " IDENTITY (" + startValue + ", " + step + ") NOT NULL";
            }
        }
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return "";
            }
        }
        protected String setDefaultValue(String defaultValue, String columnType) {
            if (defaultValue == null || defaultValue.equals("\"\"") || defaultValue.equals("")) {
                return " ";
            } else if ((defaultValue.startsWith("\"") || defaultValue.startsWith("'"))
                    && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
                return " default '" + defaultValue.substring(1, defaultValue.length() - 1) + "' ";
            } else if (defaultValue.equalsIgnoreCase("null")) {
                return " default null ";
            } else {
                return " default " + defaultValue + " ";
            }
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() + ", " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();
        }

        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            List<Column> stmtStructure = createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
            if(isSpecifyIdentityKey) {
                for(Column column : stmtStructure) {
                    if(column.name.equals(identityKey)) {
                        column.setAutoIncrement(true);
                        column.setStartValue(startValue);
                        column.setStep(step);
                        break;
                    }
                }
            }
            return stmtStructure;
        }
        
        private boolean dynamicColumnIsReplaced = false;
        
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();            
            for(IMetadataColumn column : columnList) {
                Map<String, String> fieldOption = null;
                if(fieldOptions != null && fieldOptions.size() > 0) {
                    for(Map<String, String> tmpFieldOption : fieldOptions) {
                        if(column.getLabel().equals(tmpFieldOption.get("SCHEMA_COLUMN"))) {
                            fieldOption = tmpFieldOption;
                            break;
                        }
                    }
                }
                
                Column skeletonColumn = getColumn(column, column.isKey(), useFieldOptions, fieldOption);
                skeletonColumn.setOperator("=");
                skeletonColumn.setDataType(column.getType());
                stmtStructure.add(skeletonColumn);
                
                if("id_Dynamic".equals(column.getTalendType())) {
                    skeletonColumn.setDynamic(true);
                }
            }
            
            dynamicColumnIsReplaced = false;
            
            if(addCols != null && addCols.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");                                
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacementCol.setKey(replacedCol.isKey());
                                replacementCol.setUpdateKey(replacedCol.isUpdateKey());
                                replacementCol.setDeleteKey(replacedCol.isDeleteKey());
                                replacementCol.setUpdatable(replacedCol.isUpdatable());
                                replacementCol.setInsertable(replacedCol.isInsertable());
                                replacedCol.replace(replacementCol);
                                
                                if(replacedCol.isDynamic()) {
                                    dynamicColumnIsReplaced = true;
                                }
                            }                            
                        }
                    }
                }
            }
            
            return stmtStructure;
        }
        
        public boolean isDynamicColumnReplaced() {
            return dynamicColumnIsReplaced;
        }
        
        public Map<String, StringBuilder> createProcessSQL(List<Column> stmtStructure) {
            Map<String, StringBuilder> actionSQLMap = new HashMap<String, StringBuilder>();
            if(stmtStructure==null || stmtStructure.size() < 1) {
                actionSQLMap.put(INSERT_COLUMN_NAME, new StringBuilder());
                actionSQLMap.put(INSERT_VALUE_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_SET_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(DELETE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_DELETE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_INSERT_COLUMN, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_COLUMN, new StringBuilder());
            } else {
                for(Column column : stmtStructure) {
                    if(column.isReplaced()) {
                        List<Column> replacedColumns = column.getReplacement();
                        for(Column replacedColumn : replacedColumns) {
                            actionSQLMap = processSQLClause(replacedColumn, actionSQLMap);
                        }
                    } else {
                        actionSQLMap = processSQLClause(column, actionSQLMap);        
                    }
                }
            }
            return actionSQLMap;
        }
        
        private boolean isSpecifyIdentityKey = false;
        
        public void setIsSpecifyIdentityKey(boolean isSpecifyIdentityKey) {
            this.isSpecifyIdentityKey = isSpecifyIdentityKey;
        }
        
        private Map<String, StringBuilder> processSQLClause(Column column, Map<String, StringBuilder> actionSQLMap) {
            StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
            if(insertColName == null) {
                insertColName = new StringBuilder();
            }
            StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
            if(insertValueStmt == null) {
                insertValueStmt = new StringBuilder();
            }
            StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
            if(updateSetStmt == null) {
                updateSetStmt = new StringBuilder(); 
            }
            StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
            if(updateWhereStmt == null) {
                updateWhereStmt = new StringBuilder();
            }
            StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
            if(deleteWhereStmt == null) {
                deleteWhereStmt = new StringBuilder();
            }
            StringBuilder firstUpdateKeyColumn = actionSQLMap.get(FIRST_UPDATE_KEY);
            if(firstUpdateKeyColumn == null) {
                firstUpdateKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstDeleteKeyColumn = actionSQLMap.get(FIRST_DELETE_KEY);
            if(firstDeleteKeyColumn == null) {
                firstDeleteKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstInsertColumn = actionSQLMap.get(FIRST_INSERT_COLUMN);
            if(firstInsertColumn == null) {
                firstInsertColumn = new StringBuilder("true");
            }
            StringBuilder firstUpdateColumn = actionSQLMap.get(FIRST_UPDATE_COLUMN);
            if(firstUpdateColumn == null) {
                firstUpdateColumn = new StringBuilder("true");
            }
            String suffix = null;
            String separate = null;
            String identityKey = ElementParameterParser.getValue(node, "__IDENTITY_FIELD__");
            if(!(isSpecifyIdentityKey && (column.getName().equals(identityKey))) && column.isInsertable() && !column.isDynamic()) {
                if(firstInsertColumn.toString().equals("true")) {
                    suffix = "";
                    firstInsertColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                insertColName.append(suffix);
                insertColName.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()));
                insertValueStmt.append(suffix);
                insertValueStmt.append(column.getSqlStmt());
            }
            if(column.isUpdatable() && !column.isDynamic()) {
                if(firstUpdateColumn.toString().equals("true")) {
                    suffix = "";
                    firstUpdateColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                updateSetStmt.append(suffix);
                updateSetStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " " + column.getOperator() + " " + column.getSqlStmt());
            }
            if(column.isDeleteKey() && !column.isDynamic()) {
                if(firstDeleteKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstDeleteKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                deleteWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(deleteWhereStmt, column);                 
            }
            if(column.isUpdateKey() && !column.isDynamic()) {
                if(firstUpdateKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstUpdateKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                updateWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(updateWhereStmt, column);                
                                            
            }
            actionSQLMap.put(INSERT_COLUMN_NAME, insertColName);
            actionSQLMap.put(INSERT_VALUE_STMT, insertValueStmt);
            actionSQLMap.put(UPDATE_SET_STMT, updateSetStmt);
            actionSQLMap.put(UPDATE_WHERE_STMT, updateWhereStmt);
            actionSQLMap.put(DELETE_WHERE_STMT, deleteWhereStmt);
            actionSQLMap.put(FIRST_UPDATE_KEY, firstUpdateKeyColumn);
            actionSQLMap.put(FIRST_DELETE_KEY, firstDeleteKeyColumn);
            actionSQLMap.put(FIRST_INSERT_COLUMN, firstInsertColumn);
            actionSQLMap.put(FIRST_UPDATE_COLUMN, firstUpdateColumn);
            return actionSQLMap;
        }
        public String getGenerateType(String typeToGenerate) {
            if(typeToGenerate.equals("byte[]")) {
                typeToGenerate = "Bytes";
            } else if(typeToGenerate.equals("java.util.Date")) {
                typeToGenerate = "Date";
            } else if(typeToGenerate.equals("Integer")) {
                typeToGenerate = "Int";
            } else if(typeToGenerate.equals("List")) {  
                typeToGenerate = "Object";                 
            } else {
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, dbType, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        // @Deprecated : see bug8551
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " +  replaceStr + ")";
            }else {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ")";
            }
            
                
        }
        
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit);
        }
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            String replaceStr = null;
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                    if (index == 1 && dynCol == null) {
                        return  stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                    } else {
                        return  stmt + cid + ".append(" +  replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                    }
            }else {
                if (index == 1 && dynCol == null) {
                    return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                } else {
                    return stmt + cid + ".append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                }
            }
        }
        
        //feature:2880 @6980 in debug mode
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit, replaceFixedStr);
        }
        
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if (index == 1 && dynCol == null) {
                return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +replaceFixedStr+ ").append("+sqlSplit+cid+"["+index+"])";
            } else {
                return stmt + cid + ".append(" +replaceFixedStr+").append("+sqlSplit+cid+"["+dynamicIndex+"])";
            }
        }
        
        //extract a method for feature:2880, it is a default implement, need every tDBOutput to implement it, if it really want to support the "whereNULL" issue
        //@see: the implement of MSSQLManager
        //feature:2880 @6980
        //i.e: 
        //1.select * FROM user where ((true = true AND name is NULL) OR name = ?);
        //2.select * FROM user where ((true = false AND name is NULL) OR name = ?);
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;

            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
        // for feature:2880, it will consider the "whereNULL" issue in the generated code.
        // @Deprecated: because the "index" with a small problem when increase it.
        private String generateSetStmt_4_whereSupportNull(String typeToGenerate, Column column, int index,
                String incomingConnName, String cid, int actionType) {

            boolean whereSupportNull = false;

            // if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }

            StringBuilder setStmt = new StringBuilder();

            // the 3 conditions are important
            if (column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable()) {
                setStmt.append(generateSetBooleanForNullableKeyStmt(column, index, incomingConnName, cid, NORMAL_TYPE));
            }

            // the old behave
            setStmt.append(generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, NORMAL_TYPE));

            return setStmt.toString();
        }

        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            //TODO generate setXXXX code according to each db .
            setStmt.append(prefix + cid + ".setInt(" + dynamicIndex + ",  ((" + incomingConnName + "." + column.getName() + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            return generateSetBooleanForNullableKeyStmt(null, column, index, incomingConnName, cid, actionType);
        }     
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, 
                String fieldDelimiter, 
                String newLineChar,
                String nullIndicator) {
        return null;
            
        }
        
        public String generateCode4TabelExist() {
            boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
            String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
            StringBuilder code = new StringBuilder();  
            code.append("String tableNameForSearch_" + cid + "= " + getTableName4Search(useExistingConnection, connection) + ";\r\n");
            if (hasSchema()) {
                code.append("String dbschemaForSearch_" + cid + "= null;\r\n");
                code.append("if(dbschema_" + cid + "== null || dbschema_" + cid + ".trim().length() == 0) {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getUserName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("} else {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getShemaName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("}\r\n");
            }
            return code.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + " + ElementParameterParser.getValue(node,"__TABLE__") +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }

        /*
         * maybe some db need add getLProtectedChar() and getRProtectedChar() to schema name.
         * this because of some db default add getLProtectedChar() and getRProtectedChar() to schaem when create table. e.g:db2
         * 
         * in fact the db add getLProtectedChar() and getRProtectedChar() to scheam when create table that is wrong
        */
        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }   
        
        protected boolean hasSchema() {
            return false;
        }
        
    }
    
    public class AS400Manager extends Manager {
        public AS400Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return AS400;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class AccessManager extends Manager {
        public AccessManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ACCESS;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }   
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                if (typeToGenerate.equals("Long")) {
                    setStmt.append(prefix + cid + ".setBigDecimal(" + index + ",new BigDecimal(" + incomingConnName + "." + column.getName() + "));\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class DB2Manager extends Manager {
        public DB2Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return DB2;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }       
        
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " IMMEDIATE");
            return truncateTableSQL.toString();
        }
        
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE IMMEDIATE");
            return truncate_reuse_stroage_TableSQL.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            // try to build a sql like 
            // update customers a 
            // set (city_name,customer_type)=(select b.city_name,b.customer_type 
            //        from tmp_cust_city b 
            //        where b.customer_id=a.customer_id) // wheresub
            //        where exists (select 1 
            //        from tmp_cust_city b
            //        where b.customer_id=a.customer_id
            //        )
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class FirebirdManager extends Manager {
        public FirebirdManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return FIREBIRD;
        }
        protected String getLProtectedChar() {
            return " ";
        }
        protected String getRProtectedChar() {
            return " ";
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            
            // add VectorWise option
            if ("vectorwise_id".equalsIgnoreCase(getDBMSId())){
                createSQL.append("WITH STRUCTURE = VECTORWISE");
            }
            
            return createSQL.toString();
        }
                
    }
    
    public class HSQLDBManager extends Manager {
        String [] hsqldbKeyWords = {};
        public HSQLDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HSQLDB;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHSQLDBKeyword (String keyword) {
            for (int i=0 ; i < hsqldbKeyWords.length ; i++){
                if (hsqldbKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class HiveManager extends Manager {
        String [] hiveKeyWords = {};
        public HiveManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HIVE;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHiveKeyword (String keyword) {
            for (int i=0 ; i < hiveKeyWords.length ; i++){
                if (hiveKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class InformixManager extends Manager {
        public InformixManager(String cid) {
            super(cid);
        }
        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(*) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }        
        protected String getDBMSId() {
            return INFORMIX;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class IngresManager extends Manager {
        boolean isTrimSpace = true;
        public IngresManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INGRES;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }  
        protected boolean getTrimSpace() {
            return isTrimSpace;
        }
        protected boolean setTrimSpace(boolean isTrimSpace) {
            this.isTrimSpace = isTrimSpace;
            return isTrimSpace;
        }
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, String fieldDelimiter, 
                String recordDelimiter, String nullIndicator) {     
            StringBuilder copyBulkSQL = new StringBuilder();
            copyBulkSQL.append("COPY TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            copyBulkSQL.append(" (\"+");                
            int counter = 0;
            for(IMetadataColumn column : columnList) {
                counter++;
                // add each table field and separator
                copyBulkSQL.append( 
                "\n\"\\n" +
                  column.getOriginalDbColumnName() 
                + "="
                + (!getTrimSpace() && ("VARCHAR".equalsIgnoreCase(column.getType()) || "NVARCHAR".equalsIgnoreCase(column.getType()) || "TEXT".equalsIgnoreCase(column.getType())) ? "text(0)" : "char(0)"));
            
                // add these only if not last entry
                if (counter < columnList.size()){
                    copyBulkSQL.append(
                    //convertDelim(fieldDelimiter)
                    "\"+field_delimiter_"+cid +"+\""
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    + " ,"
                    + "\""
                    + "+"
                    );
                } else {
                    copyBulkSQL.append(
                    recordDelimiter
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    );
                    copyBulkSQL.append(")");
                }       
            } 
            return copyBulkSQL.toString();
        } 

        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("MODIFY " + getLProtectedChar() + "\" + tableName_" 
            + cid + " + \"\\\" TO TRUNCATED");
            return truncateTableSQL.toString();
        }                       
    }
    
    public class VectorWiseManager extends IngresManager {
        public VectorWiseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VECTORWISE;
        }
    }   
    
    public class InterbaseManager extends Manager {
        public InterbaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INTERBASE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class JavaDBManager extends Manager {
        public JavaDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JAVADB;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class MaxDBManager extends Manager {
        public MaxDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MAXDB;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLManager extends Manager {
        public MSSQLManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MSSQL;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        } 
       
        protected String getColumnIsNullCondition() {
            return "0x1";
        }
        
        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setBoolean(" + dynamicIndex + ", (" + incomingConnName + "." + column.getName()
                    + "==null));\r\n");
            return setStmt.toString();
        } 
        
        public String generateSetStmt(String typeToGenerate, String ignoreDateOutOfRange, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                String dbType = column.getColumn().getType();
                if(dbType==null || "".equals(dbType)){
                    MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
                    dbType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                }
                boolean isMSSQL = "id_MSSQL".equals(this.getDBMSId());
                if("true".equals(ignoreDateOutOfRange) &&("DATE".equals(dbType) || "DATETIME2".equals(dbType) || "DATETIMEOFFSET".equals(dbType))){                    
                    String pattern = column.getColumn().getPattern();
                    setStmt.append("if(" + incomingConnName + "." + column.getName() +"!=null && "+ incomingConnName + "." + column.getName() + ".getTime() < year2_"+cid+"){");
                    if("DATETIMEOFFSET".equals(dbType)) {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDatetimeoffset("+incomingConnName+"."+column.getName()+"));\r\n");
                    } else {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDate("+pattern+", "+incomingConnName+"."+column.getName()+"));\r\n");
                    }
                    setStmt.append("}else{\r\n");
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                    setStmt.append("}\r\n");
                }else if(isMSSQL && "TIME".equals(dbType)){//TDI-30431 begin
                    String timePattern = column.getColumn().getPattern();
                    //Compatible with Time,Date and String,it will fail if Time contain fractional seconds.(Solution:Use sqljdbc.jar and setTime() instead)
                    //setStmt.append(prefix + cid + ".setString(" + index + dynamic + "," + incomingConnName + "." + column.getName()+".toString()");// For Time and String
                    setStmt.append(prefix + cid + ".setString(" + index + dynamic + ","
                                    + incomingConnName + "." + column.getName()
                                    +" instanceof java.util.Date ? new java.text.SimpleDateFormat("+timePattern+").format("
                                    + incomingConnName + "." + column.getName()+") : "
                                    + incomingConnName + "." + column.getName()+".toString()");//Compatible with tFileInputDelimiter Date Type and Time and String
                    setStmt.append(");\r\n");
                }else{//TDI-30431 end
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class MysqlManager extends Manager {
        public MysqlManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MYSQL;
        }
        protected String getLProtectedChar() {
            return "`";
        }
        protected String getRProtectedChar() {
            return "`";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE){
                prefix = "pstmt_";
            }else if(actionType == INSERT_TYPE){
                prefix = "pstmtInsert_";
            }else if(actionType == UPDATE_TYPE){
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append("date_" + cid + " = " + incomingConnName + "." + column.getName() + ".getTime();\r\n");
                setStmt.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"0000-00-00 00:00:00\");\r\n");
                setStmt.append("} else {");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                setStmt.append("}\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }

    public class NetezzaManager extends Manager {
        public NetezzaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return NETEZZA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                String dateType="Timestamp";
                if("TIME".equalsIgnoreCase(column.getColumn().getType())){
                    dateType = "Time";
                }
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".set"+dateType+"(" + index + dynamic + ", new java.sql."+dateType+"(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class OracleManager extends Manager {
          private String[] oracleKeyWords= {
                    "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                    "ADD","CONNECT","DISTINCT" ,
                    "ALL","BY","CREATE","DROP",
                    "ALTER","CHAR","CURRENT","ELSE",
                    "AND","CHECK","DATE","EXCLUSIVE",
                    "ANY","CLUSTER","DECIMAL"," EXISTS",
                    "AS","COLUMN","DEFAULT","FILE",
                    "ASC","COMMENT","DELETE","FLOAT",
                    "FOR","LONG","PCTFREE","SUCCESSFUL",
                    "FROM","MAXEXTENTS","PRIOR","SYNONYM",
                    "GRANT","MINUS","PRIVILEGES","SYSDATE",
                    "GROUP","MODE","PUBLIC","TABLE",
                    "HAVING","MODIFY","RAW","THEN",
                    "IDENTIFIED","NETWORK","RENAME","TO",
                    "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                    "IN","NOCOMPRESS","REVOKE","UID",
                    "INCREMENT","NOT","ROW","UNION",
                    "INDEX","NOWAIT","ROWID","UNIQUE",
                    "INITIAL","NULL","ROWNUM","UPDATE",
                    "INSERT","NUMBER","ROWS","USER",
                    "INTEGER","OF","SELECT","VALIDATE",
                    "INTERSECT","OFFLINE","SESSION","VALUES",
                    "INTO","ON","SET","VARCHAR",
                    "IS","ONLINE","SHARE","VARCHAR2",
                    "LEVEL","OPTION","SIZE","VIEW",
                    "LIKE","OR","SMALLINT","WHENEVER",
                    "LOCK","ORDER","START","WHERE","WITH"
                    };
        public OracleManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ORACLE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isOracleKeyword (String keyword) {
            for (int i=0 ; i < oracleKeyWords.length ; i++){
                if (oracleKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        private String dbVersion = "";
        public void setDbVersion(String dbVersion){
            this.dbVersion = dbVersion;  
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }        
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
        	return generateSetStmt(typeToGenerate, column.getColumn().getType(), column, index, incomingConnName, cid, actionType, dynamic);
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            if(dbType == null){
            	dbType = "";
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if( typeToGenerate.equals("String")&& dbType.toLowerCase().equals("char")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == \"\0\"){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            }
            else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
                if(isTSWithTZ && ("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) || "ORACLE_10".equals(dbVersion))){
                    setStmt.append("if("+ incomingConnName + "." + column.getName() + " instanceof TalendTimestampWithTZ){\r\n");
                    setStmt.append("((oracle.jdbc.OraclePreparedStatement)" + prefix + cid + ").setTIMESTAMPTZ(" + index + dynamic +  ", new oracle.sql.TIMESTAMPTZ(conn_" + cid + ", ((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getTimestamp(),((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getCalendar()));\r\n");
                    setStmt.append("}else{");
                    setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    setStmt.append("}");
                }else if ("Date".equalsIgnoreCase(dbType)) {
                    if (!"true".equals(ElementParameterParser.getValue(node, "__USE_TIMESTAMP_FOR_DATE_TYPE__"))) {
                        setStmt.append(prefix + cid + ".setDate(" + index + dynamic +  ", new java.sql.Date(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    } else {
                        setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
                    }
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n"); 
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic +  ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic +  ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic +  ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && (dbType.equals("XMLTYPE")||dbType.equals("CLOB")))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  clobTypeUtil_" + cid + ".getCLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  blobTypeUtil_" + cid + ".getBLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            boolean convertToUppercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
            if(convertToUppercase){
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ").toUpperCase()" +" + \"" + getRProtectedChar() + "\"";
            }else{
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
            }
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;
            String columnName = column.getColumnName();
            String dataType = column.getDataType();
            if(dataType!=null)
            {
            boolean trimChar = ("true").equals(ElementParameterParser.getValue(node,"__TRIM_CHAR__"));
            if(trimChar && "char".equals(dataType.toLowerCase()))
            {
                columnName = "trim("+columnName+")";
            }
            }
            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
    }
    
    public class PostgreManager extends Manager {
        public PostgreManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGRESQL;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class RedshiftManager extends PostgreManager {
         public RedshiftManager(String cid) {
             super(cid);
         }
         
         protected String getDBMSId() {
             return REDSHIFT;
         }
         
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                            if (!precisionIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + precision);
                            }
                            if (!lengthIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (precisionIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + length);
                            }
                            createSQL.append(suffix);
                        } else {
                            if (!lengthIgnored) {
                                if (column.getColumn().getLength() == null) {                                  
                                } else { 
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + length);                                    
                                }
                            }
                            if (!precisionIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (lengthIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + precision);
                            }
                            if (column.getColumn().getLength() == null) {
                            } else {
                                createSQL.append(suffix);
                            }
                        }
                            
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class GreenplumManager extends PostgrePlusManager {
         public GreenplumManager(String cid) {
             super(cid);
         }
         protected String getDBMSId() {
             return GREENPLUM;
         }
    }
    public class PostgrePlusManager extends Manager {
        public PostgrePlusManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGREPLUS;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class SQLiteManager extends Manager {
        public SQLiteManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SQLITE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class SybaseManager extends Manager {
         private String[] sybaseKeyWords= {
                 "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                "ADD","CONNECT","COUNT","DISTINCT" ,
                "ALL","BY","CREATE","DROP",
                "ALTER","CHAR","CURRENT","ELSE",
                "AND","CHECK","DATE","EXCLUSIVE",
                "ANY","CLUSTER","DECIMAL"," EXISTS",
                "AS","COLUMN","DEFAULT","FILE",
                "ASC","COMMENT","DELETE","FLOAT",
                "FOR","LONG","PCTFREE","SUCCESSFUL",
                "FROM","FALSE","MAXEXTENTS","PRIOR","SYNONYM",
                "GRANT","MINUS","PRIVILEGES","SYSDATE",
                "GROUP","MODE","PUBLIC","TABLE",
                "HAVING","MODIFY","RAW","THEN",
                "IDENTIFIED","NETWORK","RENAME","TO",
                "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                "IN","NOCOMPRESS","REVOKE","UID",
                "INCREMENT","NOT","ROW","UNION",
                "INDEX","NOWAIT","ROWID","UNIQUE",
                "INITIAL","NULL","ROWNUM","UPDATE",
                "INSERT","NUMBER","ROWS","USER",
                "INTEGER","OF","SELECT","VALIDATE",
                "INTERSECT","OFFLINE","SESSION","VALUES",
                "INTO","ON","SET","VARCHAR",
                "IS","ONLINE","SHARE",
                "LEVEL","OPTION","SIZE","VIEW",
                "LIKE","OR","SMALLINT","WHENEVER",
                "LOCK","ORDER","START","WHERE","WITH"
                 
         };
        public SybaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SYBASE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected boolean isSybaseKeyword (String keyword) {
            for (int i=0 ; i < sybaseKeyWords.length ; i++){
                if (sybaseKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return " null ";
            }
        }        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        

        /**
         * This method is added for differences between sybase and common databases on BigDecimal.
         * Reference issue is TDI-7505.
         * */
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("BigDecimal")){
                if(column.getColumn().getPrecision()!=null && column.getColumn().getLength()!=null){
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                    setStmt.append("((com.sybase.jdbc3.jdbc.SybPreparedStatement)"+prefix + cid + ").set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() +","+column.getColumn().getLength() +","+column.getColumn().getPrecision()+ ");\r\n");
                    setStmt.append("} else {\r\n");
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                    setStmt.append("}\r\n");
                }else{
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
                
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class TeradataManager extends Manager {
        public TeradataManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return TERADATA;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        } 
                
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BINARY);\r\n");                
                }
            } else if(typeToGenerate.equals("Byte")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TINYINT);\r\n");                
            } else if(typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.SMALLINT);\r\n");                
            } else if(typeToGenerate.equals("Long")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BIGINT);\r\n");                
            } else if(typeToGenerate.equals("Integer")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                    
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if ((typeToGenerate.equals("String")) && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setAsciiStream(" + index + ", new java.io.ByteArrayInputStream(" + incomingConnName + "." + column.getName() + ".toString().getBytes()), (" + incomingConnName + "." + column.getName() + ".toString().getBytes()).length);\r\n");                
            } else if ((typeToGenerate.equals("Bytes")) && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");    
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            
            String tableType = ElementParameterParser.getValue(node, "__CREATE_TABLE_TYPE__");
            
            createSQL.append("CREATE " + tableType + " TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class VerticaManager extends Manager {
        public VerticaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VERTICA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                if(typeToGenerate.equals("Int")) {
                    setStmt.append(prefix + cid + ".setLong(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");                 
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }
    
    public class ODBCManager extends Manager {
        public ODBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ODBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class JDBCManager extends Manager {
        String lChar = "";
        String rChar = "";
        public JDBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JDBC;
        }
        protected String getLProtectedChar() {
            return lChar;
        }
        protected String getRProtectedChar() {
            return rChar;
        }        
        public void setLProtectedChar(String lChar){
            this.lChar = lChar;
        }
        public void setRProtectedChar(String rChar){
            this.rChar = rChar;
        }
    }    
    public class SAPHanaManager extends Manager {

        private String[] sapHanaReservedWords = { "ALL", "ALTER", "AS", "BEFORE", "BEGIN", "BOTH", "CASE", "CHAR", "CONDITION",
                "CONNECT", "CROSS", "CUBE", "CURRENT_CONNECTION", "CURRENT_DATE", "CURRENT_SCHEMA", "CURRENT_TIME",
                "CURRENT_TIMESTAMP", "CURRENT_USER", "CURRENT_UTCDATE", "CURRENT_UTCTIME", "CURRENT_UTCTIMESTAMP", "CURRVAL",
                "CURSOR", "DECLARE", "DISTINCT", "ELSE", "ELSEIF", "ELSIF", "END", "EXCEPT", "EXCEPTION", "EXEC", "FOR", "FROM",
                "FULL", "GROUP", "HAVING", "IF", "IN", "INNER", "INOUT", "INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT",
                "LIMIT", "LOOP", "MINUS", "NATURAL", "NEXTVAL", "NULL", "ON", "ORDER", "OUT", "PRIOR", "RETURN", "RETURNS",
                "REVERSE", "RIGHT", "ROLLUP", "ROWID", "SELECT", "SET", "SQL", "START", "SYSDATE", "SYSTIME", "SYSTIMESTAMP",
                "SYSUUID", "TOP", "TRAILING", "UNION", "USING", "UTCDATE", "UTCTIME", "UTCTIMESTAMP", "VALUES", "WHEN", "WHERE",
                "WHILE", "WITH" };

        public SAPHanaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SAPHANA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isSapHanaReservedWords (String keyword) {
            for (int i=0 ; i < sapHanaReservedWords.length ; i++){
                if (sapHanaReservedWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSapHanaReservedWords(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            return getLProtectedChar(keyword);
        }    
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            String table_type = ElementParameterParser.getValue(node,"__TABLE_TYPE__");
            createSQL.append("CREATE "+table_type+" TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                            if (!precisionIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + precision);
                            }
                            if (!lengthIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (precisionIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + length);
                            }
                            createSQL.append(suffix);
                        } else {
                            if (!lengthIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + length);                                    
                            }
                            if (!precisionIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (lengthIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + precision);
                            }
                            createSQL.append(suffix);
                        }                            
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }

    }    
    
    public class ExasolManager extends Manager{
    
		private String[] keywords = { "ABS", "ACOS", "ADD_DAYS", "ADD_HOURS",
				"ADD_MINUTES", "ADD_MONTHS", "ADD_SECONDS", "ADD_WEEKS",
				"ADD_YEARS", "ADMIN", "ALIGN", "ALWAYS", "ANALYZE", "ANSI",
				"ASCII", "ASIN", "ASSIGNMENT", "ASYMMETRIC", "ATAN", "ATAN2",
				"ATOMIC", "AUDIT", "AUTHENTICATED", "AUTO", "AVG", "BACKUP",
				"BERNOULLI", "BIT_AND", "BIT_CHECK", "BIT_LENGTH", "BIT_NOT",
				"BIT_OR", "BIT_SET", "BIT_TO_NUM", "BIT_XOR", "BREADTH",
				"CEIL", "CEILING", "CHANGE", "CHARACTERS", "CHARACTER_LENGTH",
				"CHR", "CLEAR", "COBOL", "COLOGNE_PHONETIC", "COMMENT",
				"COMMENTS", "COMMITTED", "CONCAT", "CONNECT", "CONVERT_TZ",
				"CORR", "COS", "COSH", "COT", "COUNT", "COVAR_POP",
				"COVAR_SAMP", "CREATED", "CROSS", "CURDATE", "DATABASE",
				"DATE_TRUNC", "DAYS_BETWEEN", "DECODE", "DEFAULTS", "DEGREES",
				"DELIMIT", "DELIMITER", "DENSE_RANK", "DEPTH", "DIAGNOSTICS",
				"DICTIONARY", "DISTRIBUTE", "DISTRIBUTION", "DIV", "DOWN",
				"DUMP", "EDIT_DISTANCE", "EMITS", "ENCODING", "ESTIMATE",
				"EVALUATE", "EXA", "EXCLUDE", "EXCLUDING", "EXP", "EXPRESSION",
				"FIRST_VALUE", "FLOOR", "FLUSH", "FOREIGN", "FORTRAN",
				"FROM_POSIX_TIME", "GREATEST", "GROUPING_ID", "HANDLER", "HAS",
				"HASH", "HASH_MD5", "HASH_SHA", "HASH_SHA1", "HASH_TIGER",
				"HIERARCHY", "HOURS_BETWEEN", "IDENTIFIED", "IGNORE",
				"INCLUDING", "INITIALLY", "INSTR", "INVALID", "ISOLATION",
				"IS_BOOLEAN", "IS_DATE", "IS_DSINTERVAL", "IS_NUMBER",
				"IS_TIMESTAMP", "IS_YMINTERVAL", "JAVA", "JAVASCRIPT", "KEEP",
				"KEY", "KEYS", "KILL", "LAG", "LANGUAGE", "LAST_VALUE",
				"LCASE", "LEAD", "LEAST", "LENGTH", "LINK", "LN", "LOCATE",
				"LOCK", "LOG10", "LOG2", "LOGS", "LONG", "LOWER", "LPAD",
				"LTRIM", "LUA", "MAX", "MAXIMAL", "MEDIAN", "MID", "MIN",
				"MINUTES_BETWEEN", "MONTHS_BETWEEN", "MUMPS", "NEVER", "NICE",
				"NORMALIZED", "NOW", "NULLIFZERO", "NULLS", "NUMTODSINTERVAL",
				"NUMTOYMINTERVAL", "NVL", "OCTETS", "OCTET_LENGTH", "OFFSET",
				"OPTIMIZE", "ORA", "OWNER", "PADDING", "PARTITION", "PASCAL",
				"PERCENTILE_CONT", "PERCENTILE_DISC", "PI", "PLI",
				"POSIX_TIME", "POWER", "PRECISION", "PRELOAD", "PRIMARY",
				"PRIORITY", "PRIVILEGE", "PYTHON", "QUERY_CACHE",
				"QUERY_TIMEOUT", "R", "RADIANS", "RAND", "RANK",
				"RATIO_TO_REPORT", "RECOMPRESS", "RECORD", "REGEXP_INSTR",
				"REGEXP_REPLACE", "REGEXP_SUBSTR", "REGR_AVGX", "REGR_AVGY",
				"REGR_COUNT", "REGR_INTERCEPT", "REGR_R2", "REGR_SLOPE",
				"REGR_SXX", "REGR_SXY", "REGR_SYY", "REJECT", "REORGANIZE",
				"REPEATABLE", "REVERSE", "ROLE", "ROUND", "ROWID",
				"ROW_NUMBER", "RPAD", "RTRIM", "SCALAR", "SCHEMAS", "SCHEME",
				"SECONDS_BETWEEN", "SECURE", "SERIALIZABLE", "SHUT", "SIGN",
				"SIMPLE", "SIN", "SINH", "SIZE", "SKIP", "SOUNDEX", "SQRT",
				"STATISTICS", "STDDEV", "STDDEV_POP", "STDDEV_SAMP", "ST_AREA",
				"ST_BOUNDARY", "ST_BUFFER", "ST_CENTROID", "ST_CONTAINS",
				"ST_CONVEXHULL", "ST_CROSSES", "ST_DIFFERENCE", "ST_DIMENSION",
				"ST_DISJOINT", "ST_DISTANCE", "ST_ENDPOINT", "ST_ENVELOPE",
				"ST_EQUALS", "ST_EXTERIORRING", "ST_FORCE2D", "ST_GEOMETRYN",
				"ST_GEOMETRYTYPE", "ST_INTERIORRINGN", "ST_INTERSECTION",
				"ST_INTERSECTS", "ST_ISCLOSED", "ST_ISEMPTY", "ST_ISRING",
				"ST_ISSIMPLE", "ST_LENGTH", "ST_NUMGEOMETRIES",
				"ST_NUMINTERIORRINGS", "ST_NUMPOINTS", "ST_OVERLAPS",
				"ST_POINTN", "ST_SETSRID", "ST_STARTPOINT", "ST_SYMDIFFERENCE",
				"ST_TOUCHES", "ST_TRANSFORM", "ST_UNION", "ST_WITHIN", "ST_X",
				"ST_Y", "SUBSTR", "SUM", "SYMMETRIC", "SYS_CONNECT_BY_PATH",
				"SYS_GUID", "TABLES", "TABLESAMPLE", "TAN", "TANH", "TASKS",
				"TIES", "TIME_ZONE", "TIME_ZONE_BEHAVIOR", "TO_CHAR",
				"TO_DATE", "TO_DSINTERVAL", "TO_NUMBER", "TO_TIMESTAMP",
				"TO_YMINTERVAL", "TRANSLATE", "TRUNC", "TYPE", "UCASE",
				"UNBOUNDED", "UNCOMMITTED", "UNDO", "UNICODE", "UNICODECHR",
				"UNLIMITED", "UPPER", "UTF8", "VARIANCE", "VARYING", "VAR_POP",
				"VAR_SAMP", "WEEK", "WRITE", "YEARS_BETWEEN", "ZEROIFNULL" };
				
        public ExasolManager(String cid) {
            super(cid);
        }

        protected boolean isReservedWord(String keyword) {
            for (int i=0 ; i < keywords.length ; i++){
                if (keywords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }

        protected String getDBMSId() {
            return EXASOL;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected String getLProtectedChar(String name) {
        	if (contaionsSpaces(name) || isReservedWord(name)) {
	            return "\\\"";
        	} else {
        		return "";
        	}
        }
        protected String getRProtectedChar(String name) {
        	if (contaionsSpaces(name) || isReservedWord(name)) {
	            return "\\\"";
        	} else {
        		return "";
        	}
        }  
    }
    public class UnDefinedManager extends Manager{
        
        private String dbmsId = "";
        
        public UnDefinedManager(String cid) {
            super(cid);
        }
        public void setDBMSId(String dbmsId){
            this.dbmsId = dbmsId;
        }
        protected String getDBMSId() {
            return this.dbmsId;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    public Manager getManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                manager = new MSSQLManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreManager(cid);
            } else if(dbmsId.equalsIgnoreCase(REDSHIFT)) {
                manager = new RedshiftManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ODBC)) {
                manager = new ODBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JDBC)) {
                manager = new JDBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    
    
    public Manager getManager(String dbmsId, String cid, INode node) {
        Manager manager = getManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }    
    
    public List<IMetadataColumn> getColumnList(INode node) {
        List<IMetadataColumn> columnList = null;
        List<IMetadataTable> metadatas = node.getMetadataList();
        if(metadatas != null && metadatas.size() > 0) {
            IMetadataTable metadata = metadatas.get(0);
            if(metadata != null) {
                columnList = metadata.getListColumns();
                if(metadata.isDynamicSchema() && columnList!=null) {
                    for(int i=columnList.size()-1; i>-1; i--) {
                        IMetadataColumn column = columnList.get(i);
                        if("id_Dynamic".equals(column.getTalendType())){
                            talendDynamicColumn = column;
                            break;
                        }
                    }
                }
            }
        }
        return columnList;
    }
    
    private IMetadataColumn talendDynamicColumn = null;
    
    public IMetadataColumn getDynamicColumn() {
        return talendDynamicColumn;
    }
    
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_4);
    
            }
            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_7);
    for(String message : messages){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_14);
    
            java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
            ignoredParamsTypes.addAll(
                java.util.Arrays.asList(
                    org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                    org.talend.core.model.process.EParameterFieldType.LABEL,
                    org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                    org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                    org.talend.core.model.process.EParameterFieldType.IMAGE,
                    org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                    org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                    org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                    org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                    org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                    org.talend.core.model.process.EParameterFieldType.VERSION,
                    org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                    org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                    org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                    org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                    org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                    org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                    org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                    )
            );
            for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                    continue;
                }
                String name = ep.getName();
                if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                    String epName = "__" + name + "__";
                    String password = "";
                    if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                        password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                    }else{
                        String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                        if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
                        password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                    } 
                    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_18);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_19);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_22);
    
                }   
                
    stringBuffer.append(TEXT_23);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_24);
    
            }
        }
        debug(var("log4jParamters"));
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_26);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_27);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    
                }else{
                
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_39);
    
                }
                
    stringBuffer.append(TEXT_40);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_41);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    stringBuffer.append(TEXT_42);
    
class DBConnLogUtil extends BasicLogUtil{
	
	private DBConnLogUtil(){}
	
	protected DBConnLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logJDBCDriver(String driverClass){
		debug(str("Driver ClassName: "), driverClass, str("."));
	}
	
	public void connTry(String url, String dbUser){
		if(dbUser != null){
			debug(str("Connection attempts to '"), url, str("' with the username '"), dbUser, str("'."));
		}else{
			debug(str("Connection attempts to '"), url, str("'."));
		}
	}
	
	public void connDone(String url){
		debug(str("Connection to '"), url, str("' has succeeded."));
	}
	
	public void useExistConn(String url, String dbUser){
		if(dbUser != null){
			debug(str("Uses an existing connection with username '"), dbUser, str("'. Connection URL: "), url, str("."));
		}else{
			debug(str("Uses an existing connection. Connection URL: "), url, str("."));
		}
	}
	
	public void closeTry(String connCompID){
		if(connCompID == null){
			debug(str("Closing the connection to the database."));
		}else{
			debug(str("Closing the connection "), connCompID, str(" to the database."));
		}
	}
	
	public void closeDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection to the database has closed."));	
		}else{
			debug(str("Connection "), connCompID, str(" to the database has closed."));
		}
	}
}

class DBTableActionLogUtil extends BasicLogUtil{
	private DBTableActionLogUtil(){}
	
	protected DBTableActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void dropTry(String tableName){
		tableActionTry(tableName, str("Dropping"));
	}
	
	public void dropDone(String tableName){
		tableActionDone(tableName, str("Drop"));
	}
	
	public void createTry(String tableName){
		tableActionTry(tableName, str("Creating"));
	}
	
	public void createDone(String tableName){
		tableActionDone(tableName, str("Create"));
	}
	
	public void clearTry(String tableName){
		tableActionTry(tableName, str("Clearing"));
	}
	
	public void clearDone(String tableName){
		tableActionDone(tableName, str("Clear"));
	}
	
	public void truncateTry(String tableName){
		tableActionTry(tableName, str("Truncating"));
	}
	
	public void truncateDone(String tableName){
		tableActionDone(tableName, str("Truncate"));
	}
	
	public void truncateReuseStorageTry(String tableName){
		tableActionTry(tableName, str("Truncating reuse storage"));
	}
	
	public void truncateReuseStorageDone(String tableName){
		tableActionDone(tableName, str("Truncate reuse stroage"));
	}
	
	private void tableActionTry(String tableName, String action){
		debug(action, str(" table '"), tableName, str("'."));
	}
	
	private void tableActionDone(String tableName, String action){
		debug(action, str(" table '"), tableName, str("' has succeeded."));
	}
}

class DBCommitLogUtil extends BasicLogUtil{
	private DBCommitLogUtil(){}
	
	protected DBCommitLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logAutoCommit(String autoCommit){
		debug(str("Connection is set auto commit to '"), autoCommit, str("'."));
	}

	public void commitTry(String connCompID, String commitCount){
		if(commitCount == null && connCompID == null){
			debug(str("Connection starting to commit."));
		}else if(commitCount == null){
			debug(str("Connection "), connCompID, str(" starting to commit."));	
		}else if(connCompID == null){
			debug(str("Connection starting to commit "), commitCount, str(" record(s)."));
		}else{
			debug(str("Connection "), connCompID, str(" starting to commit "), commitCount, str(" record(s)."));
		}
	}
	
	public void commitDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection commit has succeeded."));
		}else{
			debug(str("Connection "), connCompID, (" commit has succeeded."));
		}
	}
}

class DBBatchLogUtil extends BasicLogUtil{
	private DBBatchLogUtil(){}
	
	protected DBBatchLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void executeTry(String action){
		debug(str("Executing the "), action, str(" batch."));
	}
	
	public void executeDone(String action){
		debug(str("The "), action, str(" batch execution has succeeded."));
	}
}

class DBDataActionLogUtil extends BasicLogUtil{
	private DBDataActionLogUtil(){}
	
	protected DBDataActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void inserting(String nbline){
		sqlAction(nbline, str("Inserting"));
	}
	
	public void deleting(String nbline){
		sqlAction(nbline, str("Deleting"));
	}
	
	public void updating(String nbline){
		sqlAction(nbline, str("Updating"));
	}
	
	public void replacing(String nbline){
		sqlAction(nbline, str("Replacing"));
	}
	
	public void insertingOnDuplicateKeyUpdating(String nbline){
		sqlAction(nbline, str("Inserting on duplicate key updating"));
	}
	
	public void insertingIgnore(String nbline){
		sqlAction(nbline, str("Inserting ignore"));
	}
	
	private void sqlAction(String nbline, String action){
		if(nbline == null){
			debug(action, str(" the record."));
		}else{
			debug(action, str(" the record "), nbline, str("."));
		}
	}
	
	public void sqlExecuteTry(String sql){
		debug(str("Executing '"), sql, str("'."));
	}
	
	public void sqlExecuteDone(String sql){
		debug(str("Execute '"), sql, str("' has succeeded."));
	}

	public void addingToBatch(String nbline, String batchAction){
		debug(str("Adding the record "), nbline, str(" to the "), batchAction, str(" batch."));
	}
}

class DBStateLogUtil extends BasicLogUtil{
	private DBStateLogUtil(){}
	
	protected DBStateLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logInsertedLines(String nbline){
		logFinishedLines(nbline, str("inserted"));
	}
	
	public void logUpdatedLines(String nbline){
		logFinishedLines(nbline, str("updated"));
	}
	
	public void logDeletedLines(String nbline){
		logFinishedLines(nbline, str("deleted"));
	}
	
	public void logRejectedLines(String nbline){
		logFinishedLines(nbline, str("rejected"));
	}
	
	private void logFinishedLines(String nbline, String action){
		debug(str("Has "), action, str(" "), nbline, str(" record(s)."));
	}
}	
class DBLogUtil extends LogUtil{
	DBConnLogUtil conn = null;
	DBTableActionLogUtil table = null;
	DBCommitLogUtil commit = null;
	DBBatchLogUtil batch = null;
	DBDataActionLogUtil data = null;
	DBStateLogUtil state = null;
	private DBLogUtil(){}
	
	protected DBLogUtil(org.talend.core.model.process.INode node){
		super(node);
		conn = new DBConnLogUtil(node);
    	table = new DBTableActionLogUtil(node);
    	commit = new DBCommitLogUtil(node);
    	batch = new DBBatchLogUtil(node);
    	data = new DBDataActionLogUtil(node);
    	state = new DBStateLogUtil(node);
	}
	
	public DBConnLogUtil conn(){
		return conn;
	}
	
	public DBTableActionLogUtil table(){
		return table;
	}
	
	public DBCommitLogUtil commit(){
		return commit;
	}
	
	public DBBatchLogUtil batch(){
		return batch;
	}
	
	public DBDataActionLogUtil data(){
		return data;
	}
	
	public DBStateLogUtil state(){
		return state;
	}
}
DBLogUtil dbLog = null;

    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    IProcess process = node.getProcess();
    String cid = node.getUniqueName();

    if(cid.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
         cid = cid.substring(0,cid.length()-4);
    }
    
    dbLog = new DBLogUtil(node);

    String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
    String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");
    String table = ElementParameterParser.getValue(node,"__TABLE__");
    String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    boolean onErrDie = "true".equals(dieOnError);
    String tableName = ElementParameterParser.getValue(node,"__TABLE__");
    String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");
    List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADD_COLS__");

    boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));

    List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");

    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    boolean extendedInsert = ("true").equals(ElementParameterParser.getValue(node, "__EXTENDINSERT__"));

        //to fixed: bug8422
        if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))||(!("INSERT").equals(dataAction))){
            extendedInsert = false;
        }

    String numPerInsert = ElementParameterParser.getValue(node, "__NB_ROWS_PER_INSERT__");
    boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DEBUG_MODE__"));

    //feature:2880
    getManager(dbmsId, cid, node);
    boolean whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");

    boolean useBatchSize = ("true").equals(ElementParameterParser.getValue(node,"__USE_BATCH_SIZE__"));
    String batchSize=ElementParameterParser.getValue(node,"__BATCH_SIZE__");

    String incomingConnName = null;
    List<IMetadataColumn> columnList = getColumnList(node);

    List< ? extends IConnection> conns = node.getIncomingConnections();
    if(conns!=null && conns.size()>0){
        IConnection conn = conns.get(0);
        incomingConnName = conn.getName();
    }

    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");

    IMetadataTable metadataTable = null;
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
        metadataTable = rejectConn.getMetadataTable();
    }
    List<IMetadataColumn> rejectColumnList = null;
    // IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();
    }

    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    for(IConnection conn : outgoingConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    
        }
    }

    Manager manager = null;
    boolean isDynamic = false;
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        isDynamic = metadata.isDynamicSchema();
    }

    List<Column> stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
    isDynamic = isDynamic && !getManager(dbmsId, cid).isDynamicColumnReplaced();
    IMetadataColumn talendDynCol = null;
    if(isDynamic) {
    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
        ///// hint options/////
boolean useHintOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_HINT_OPTIONS__"));
Map<String, String> hintsValues = null;
if (useHintOptions) {
    List<Map<String, String>> hintOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HINT_OPTIONS__");
    hintsValues = new HashMap<String, String>();
    String hintValue = null;
    boolean firstInsert = true;
    boolean firstUpdate = true;
    boolean firstDelete = true;
    boolean firstTableName = true;
    for(java.util.Map<String, String> option : hintOptions) {
        //get
        hintValue = option.get("HINT");
        //set
        if ("INSERT".equalsIgnoreCase(option.get("SQL_STMT"))){
            if(firstInsert){
                hintsValues.put("INSERT", hintValue) ;
                firstInsert = false;
            }else {
                hintsValues.put("INSERT", hintsValues.get("INSERT") + "+" + hintValue) ;
            }
        }else if ("UPDATE".equalsIgnoreCase(option.get("SQL_STMT"))) {
            if(firstUpdate){
                hintsValues.put("UPDATE", hintValue) ;
                firstUpdate = false;
            }else {
                hintsValues.put("UPDATE", hintsValues.get("UPDATE") + "+" + hintValue) ;
            }
        }else if ("DELETE".equalsIgnoreCase(option.get("SQL_STMT"))) {
            if (firstDelete){
                hintsValues.put("DELETE", hintValue) ;
                firstDelete =false;
            }else {
                hintsValues.put("DELETE", hintsValues.get("DELETE") + "+" + hintValue) ;
            }
        }
    }
}
//// hint options end ////

if(columnList != null && columnList.size() > 0) {
    
    
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
boolean convertToUppercase_tableAction = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"
    manager = getManager(dbmsId, cid);
    String ending="";

    if("VECTORWISE".equalsIgnoreCase(dbmsId)) {
        ending="WITH STRUCTURE = VECTORWISE";
    }

    boolean useCascade = "true".equals(ElementParameterParser.getValue(node,"__USE_CASCADE__"));
    //bugfix: TDI-31650
    boolean setQueryTimeOut = false;
    String queryTimeOutInSeconds = null;
    if(SYBASE.equalsIgnoreCase(dbmsId)){
            setQueryTimeOut = "true".equals(ElementParameterParser.getValue(node,"__SET_QUERY_TIMEOUT__"));
            queryTimeOutInSeconds = ElementParameterParser.getValue(node,"__QUERY_TIMEOUT_IN_SECONDS__");
    }

    if(!("NONE").equals(tableAction)) {
        if(("DROP_CREATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_52);
    
               }
             
    dbLog.table().dropTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_55);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_56);
    dbLog.table().dropDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_63);
    
               }
             
    dbLog.table().createTry(dbLog.var("tableName"));
    
            if(isDynamic) {
                List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    String query=manager.getCreateTableSQL(stmtStructure);
                    
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_69);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_72);
    
                }
            } else {
            
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_75);
    
            }
            
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
        } else if(("CREATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_83);
    
               }
             
    dbLog.table().createTry(dbLog.var("tableName"));
    
            if(isDynamic) {
                List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    String query=manager.getCreateTableSQL(stmtStructure);
                    
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_89);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_92);
    
                }
            } else {
            
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_95);
    
            }
            
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
            boolean tableNameCaseSensitive=false;
            if(DB2.equalsIgnoreCase(dbmsId)||POSTGRESQL.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
                tableNameCaseSensitive=true;
            }
            
    
            //to fixed: bug8422
            if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
            
    stringBuffer.append(TEXT_98);
    //bug22719: informix use independent connection, should remove this code after use shared connection
                if(INFORMIX.equalsIgnoreCase(dbmsId)){
                    String dbnameKey = ElementParameterParser.getValue(node, "__DBNAME__");
                    String dbserverKey = ElementParameterParser.getValue(node, "__DBSERVER__");
                    String dbhostKey = ElementParameterParser.getValue(node, "__HOST__");
                    String dbportKey = ElementParameterParser.getValue(node, "__PORT__");
                    String tableSchemaKey = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
                    
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(dbhostKey);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(dbportKey);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(dbnameKey);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(dbserverKey);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(tableSchemaKey);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_106);
    }else{
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
            }
            
    
                            /*
                            case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
                            so in mssql use "Select" checked the table whether exist.
                            */
                            //TODO we will use like "select" sql intead of use system table to checked table?
                            if(MSSQL.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
                            } else if (ORACLE.equalsIgnoreCase(dbmsId) || SAPHANA.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_124);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
                            } else if ( SYBASE.equalsIgnoreCase(dbmsId)
                                        || INFORMIX.equalsIgnoreCase(dbmsId) ) {
                            
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
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
                            } else if( DB2.equalsIgnoreCase(dbmsId) || TERADATA.equalsIgnoreCase(dbmsId)){
                            
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_177);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_181);
    }
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
                            } else if (GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) || POSTGREPLUS.equalsIgnoreCase(dbmsId) || VERTICA.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_213);
    }
    stringBuffer.append(TEXT_214);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_217);
    }
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
                            } else if(EXASOL.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
                            } else if(REDSHIFT.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    
                            } else {
                            
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    
                            }
                            
    
                            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {
                            
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    
                                       if(setQueryTimeOut){
                                            
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_280);
    
                                       }
                                     
    dbLog.table().createTry(dbLog.var("tableName"));
    
                                    if(isDynamic) {
                                        List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                                        if(conns_dynamic!=null && conns_dynamic.size()>0){
                                            String query=manager.getCreateTableSQL(stmtStructure);
                                            
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_285);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_286);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_287);
    }
    stringBuffer.append(TEXT_288);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_289);
    
                                        }
                                    } else {
                                    
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_292);
    
                                    }
                                    
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    
                            } else {
                            
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    
                                       if(setQueryTimeOut){
                                            
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_301);
    
                                       }
                                     
    dbLog.table().dropTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_304);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_305);
    dbLog.table().dropDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    
                                   if(setQueryTimeOut){
                                        
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_312);
    
                                   }
                                 
    dbLog.table().createTry(dbLog.var("tableName"));
    
                                if(isDynamic) {
                                    List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                                    if(conns_dynamic!=null && conns_dynamic.size()>0){
                                        String query=manager.getCreateTableSQL(stmtStructure);
                                        
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_316);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_317);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_318);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_319);
    }
    stringBuffer.append(TEXT_320);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_321);
    
                                    }
                                } else {
                                
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_324);
    
                                }
                                
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    
                            }
                            
    
            //to fixed: bug8422
            if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
            
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    
            }
            
    
        } else if(("CLEAR").equals(tableAction)) {
        
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_334);
    
               }
             
    dbLog.table().clearTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_337);
    dbLog.table().clearDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    
        }else if(("TRUNCATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_345);
    
               }
             
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_360);
    
               }
             
    dbLog.table().truncateTry(dbLog.var("tableName"));
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    }
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_365);
    if(INFORMIX.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_366);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    }
    dbLog.table().truncateDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    
        } else if(("TRUNCATE_REUSE_STORAGE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    dbLog.table().truncateReuseStorageTry(dbLog.var("tableName"));
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    }
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(manager.getTruncateReuseStroageTableSQL());
    stringBuffer.append(TEXT_385);
    dbLog.table().truncateReuseStorageDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    
        }
    }
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    
    Map<String, StringBuilder> actionSQLMap = getManager(dbmsId, cid).createProcessSQL(stmtStructure);
    StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
    StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
    StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
    StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
    StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
    talendDynCol = getDynamicColumn();
    boolean supportDuplicateUpdate = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__ON_DUPLICATE_KEY_UPDATE__"));

    if(("INSERT").equals(dataAction)) {

        if (supportDuplicateUpdate) {
            List<Map<String, String>> duplicateKeys = (List<Map<String,String>>)ElementParameterParser.getObjectValue( node,"__DUPLICATED_KEYS__" );

            if (duplicateKeys.size() > 0) {
            
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    
                for (int i=0; i< duplicateKeys.size() ; i++) {
                    if (i >0) {
                    
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    
                    }
                    
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(duplicateKeys.get(i).get("DUPLICATED_KEY"));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(duplicateKeys.get(i).get("DUPLICATED_VALUE"));
    stringBuffer.append(TEXT_402);
    
                }
            }
        }

    stringBuffer.append(TEXT_403);
    
            if(!extendedInsert) {
            List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    IConnection conn = conns_dynamic.get(0);

                    if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_407);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_408);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_409);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_411);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_412);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_413);
                      } else {

    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_417);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_418);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_420);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_421);
    
                    }
                }

                
    
                if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    
                }

    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    }
    stringBuffer.append(TEXT_433);
    
                //to fixed: bug8422
                if(!(cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    }
    stringBuffer.append(TEXT_438);
    
                //to fixed: bug8422
                if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){ 
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    }
    stringBuffer.append(TEXT_452);
    
        } else {//extended-insert mode(begin)
            if ("MYSQL_4".equals(dbVersion)) {

    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_455);
    
            if(isDynamic) {
                 List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
                 if(conns_dynamic!=null && conns_dynamic.size()>0){
                    IConnection conn = conns_dynamic.get(0);

    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_458);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_459);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_460);
    
                }
            } else {

    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_463);
    
            }

    stringBuffer.append(TEXT_464);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    
                List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    IConnection conn = conns_dynamic.get(0);
                    if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_470);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_471);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_472);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
                      } else {

    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_478);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_479);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    
                    }
                if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    
                }

    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    }
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    
                    if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_499);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_500);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_501);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_504);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_505);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_506);
    
                    } else {

    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_509);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_510);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_513);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_514);
    
                    }
                }
            if(isDynamic) {

    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    
            } else {

    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    
            }
        } else if ("MYSQL_5".equals(dbVersion) || "MARIADB".equals(dbVersion)) {
                List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    IConnection conn = conns_dynamic.get(0);
                    if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_522);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_523);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_524);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_526);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_527);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_528);
                      } else {

    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_532);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_533);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_535);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_536);
    
                    }
                }
                if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    
                }
                if(isDynamic) {

    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    
                } else {

    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    
                }

    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    }
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    
            }
        }//extended-insert mode(end)
    } else if (("UPDATE").equals(dataAction)) {
        List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
        if(conns_dynamic!=null && conns_dynamic.size()>0){
            IConnection conn = conns_dynamic.get(0);
            if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_563);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_564);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_565);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_567);
              } else {

    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_571);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_572);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_574);
    
            }
        }
        
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    }
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    
    } else if (("INSERT_OR_UPDATE").equals(dataAction)) {
            List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
            if(conns_dynamic!=null && conns_dynamic.size()>0){
                IConnection conn = conns_dynamic.get(0);

                if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_590);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_591);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_592);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_594);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_595);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_596);
                      } else {

    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_600);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_601);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_602);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_603);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_604);
    
                }
                if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_608);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_609);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_610);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_611);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_612);
                  } else {

    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_616);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_617);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_618);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_619);
    
                }
            }
        
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_627);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_628);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    }
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    }
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    
    } else if (("UPDATE_OR_INSERT").equals(dataAction)) {
            List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
            if(conns_dynamic!=null && conns_dynamic.size()>0){
                IConnection conn = conns_dynamic.get(0);

                if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_656);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_657);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_658);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_660);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_661);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_662);
                      } else {

    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_666);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_667);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_668);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_669);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_670);
    
                }
                if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_674);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_675);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_676);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_677);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_678);
                  } else {

    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_682);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_683);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_684);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_685);
    
                }
            }
        
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    }
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    }
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    
    } else if (("DELETE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(deleteWhereStmt.toString());
    stringBuffer.append(TEXT_713);
    if(useHintOptions && hintsValues.get("DELETE") != null) {
  
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(hintsValues.get("DELETE"));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    
  }
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_725);
    
    } else if(("REPLACE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_729);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    
    } else if(("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_737);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_738);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_742);
    
    } else if(("INSERT_IGNORE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_744);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_746);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_747);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_750);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_755);
    }
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    
    }
    if(isEnableDebug) {
        
    
	     if(("INSERT").equals(dataAction) || ("INSERT_IGNORE").equals(dataAction)) {

    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_762);
    
		} else if (("UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_766);
    		
		} else if (("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {

    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_771);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_772);
    
		} else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_776);
    		
		} else if (("REPLACE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_777);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_778);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_780);
    
		} else if (("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_784);
    
		}else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {//MSSQL

    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_787);
    
		}

    
    }
}
    
    stringBuffer.append(TEXT_788);
    
    }


    ////////////////////////////////////////////////////////////
    List<Column> colStruct =  new ArrayList();
    for(Column colStmt : stmtStructure){
        if(!colStmt.isReplaced() && !colStmt.isAddCol() && !colStmt.isDynamic()){
            colStruct.add(colStmt);
        }
    }

    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
    if(("true").equals(useExistingConn)) {
        if(connection.matches("^.*?tAmazonAuroraConnection_\\d+$")){
                  dbVersion = "MYSQL_5";
            }else{
                List<? extends INode> nodes =  process.getNodesOfType("tMysqlConnection");
                for (INode ne:nodes) {
                    if (connection.equals(ne.getUniqueName())) {
                        dbVersion = ElementParameterParser.getValue(ne, "__DB_VERSION__");
                    }
                }
            }
    } else {
        dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
    }

    class ExtendInsertOperation{
        public String generateType(String typeToGenerate){
            if(("byte[]").equals(typeToGenerate)){
                typeToGenerate = "Bytes";
            }else if(("java.util.Date").equals(typeToGenerate)){
                typeToGenerate = "Date";
            }else if(("Integer").equals(typeToGenerate)){
                typeToGenerate = "Int";
            }else if(("List").equals(typeToGenerate)){
                typeToGenerate = "Object";
            }else{
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }

        public void generateSetStmt(String typeToGenerate, Column column, String incomingConnName, String cid){
            boolean isObject = false;
            String prefix = "pstmt_";
            
    stringBuffer.append(TEXT_789);
    
            if(("Character").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_790);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_792);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_794);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_795);
    
            }else if(("Date").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_796);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_798);
    stringBuffer.append(TEXT_799);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_801);
    
            }else if(("byte[]").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_802);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_803);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_804);
    stringBuffer.append(TEXT_805);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_807);
    
            }else if(("Long").equals(typeToGenerate)||("Byte").equals(typeToGenerate)||("Integer").equals(typeToGenerate)||("Short").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_808);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_809);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_810);
    stringBuffer.append(TEXT_811);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_812);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_813);
    
            }else if(("String").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_814);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_816);
    stringBuffer.append(TEXT_817);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_818);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_819);
    
            }else if(("Object").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_820);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_822);
    stringBuffer.append(TEXT_823);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_825);
    
            }else if(("Boolean").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_826);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_828);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_830);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_831);
    
            }else if(("Double").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_832);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_833);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_834);
    stringBuffer.append(TEXT_835);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_837);
    
            }else if(("Float").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_838);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_839);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_840);
    stringBuffer.append(TEXT_841);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_842);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_843);
    
            }
            if(isObject){
                
    stringBuffer.append(TEXT_844);
    
            }
            typeToGenerate = generateType(typeToGenerate);

            if(("Char").equals(typeToGenerate)||("Character").equals(typeToGenerate)){
                
    
                if(isObject) {
                    
    stringBuffer.append(TEXT_845);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_846);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_847);
    
                } else {
                    
    stringBuffer.append(TEXT_848);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_849);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_850);
    
                }
                
    stringBuffer.append(TEXT_851);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_854);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_855);
    stringBuffer.append(TEXT_856);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_858);
    stringBuffer.append(TEXT_859);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_861);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_862);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_863);
    
            }else if(("Date").equals(typeToGenerate)){
                
    stringBuffer.append(TEXT_864);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_865);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_866);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_867);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_868);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_869);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_870);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_871);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_872);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_873);
    stringBuffer.append(TEXT_874);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_875);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(TEXT_877);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_878);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_879);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_880);
    stringBuffer.append(TEXT_881);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_882);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_883);
    
            }else{
                
    stringBuffer.append(TEXT_884);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_885);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_887);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_888);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_889);
    
            }
            if(isObject){
                
    stringBuffer.append(TEXT_890);
    
            }
        }
    }

    if(isEnableDebug) {

    stringBuffer.append(TEXT_891);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_892);
    
    }

    boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));

    if (isParallelize) { // bug0014422
        String tAsyncIn_cid = "";
        if(conns!=null && conns.size() > 0) {
            tAsyncIn_cid = conns.get(0).getSource().getUniqueName();
            if(tAsyncIn_cid !=null && tAsyncIn_cid.matches("^.*?tAmazonAuroraOutput_\\d+_in$")){
                 tAsyncIn_cid = "tAsyncIn_" + tAsyncIn_cid.substring(0,tAsyncIn_cid.length()-3);
            }
        }
        if(!"true".equals(useExistingConn)) {
            if(!("").equals(commitEvery)&&!("0").equals(commitEvery)) {

    stringBuffer.append(TEXT_893);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_894);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_895);
    
            }
        }
        if ("MYSQL_5".equals(dbVersion) || "MARIADB".equals(dbVersion)) {
            if ((extendedInsert&&"INSERT".equals(dataAction)) || (useBatchSize&&("UPDATE".equals(dataAction)||"DELETE".equals(dataAction)))) {
                if((!("").equals(numPerInsert)&&!("0").equals(numPerInsert))
                    ||(!("").equals(batchSize)&&!("0").equals(batchSize))) {

    stringBuffer.append(TEXT_896);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_897);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_898);
    
                }
            }
        }

    stringBuffer.append(TEXT_899);
    
    }

    if(incomingConnName != null && columnList != null){
        
    stringBuffer.append(TEXT_900);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_901);
    
        if(("INSERT").equals(dataAction)) {
            if(extendedInsert) {//extended-insert mode(begin)
                if ("MYSQL_4".equals(dbVersion)) {
                    ExtendInsertOperation eiOperation = new ExtendInsertOperation();
                    int insertableCount = 0;
                    for(Column column : colStruct) {
                        if(column.isInsertable()) {
                            insertableCount++;
                        }
                    }
            if(!isDynamic) {
                    
    stringBuffer.append(TEXT_902);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_903);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_904);
    stringBuffer.append(insertableCount);
    stringBuffer.append(TEXT_905);
    
            }
                    for(Column column : colStruct) {
                        if(column.isInsertable()) {
                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                            eiOperation.generateSetStmt(typeToGenerate,column,incomingConnName,cid);
                            
    stringBuffer.append(TEXT_906);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_907);
    
                        }
                    }
                    if(isDynamic) {
                        Column dynamicColumn = getColumn(getDynamicColumn());
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                        if("Dynamic".equals(typeToGenerate)) {
                        
    stringBuffer.append(TEXT_908);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_909);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_910);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_911);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_912);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_913);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_915);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_916);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_917);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_919);
    
                    int count =0;
                    for(Column column : colStruct) {
                        if(column.isInsertable()) {
                            if(count != 0) {
                                
    stringBuffer.append(TEXT_920);
    
                            }
                            
    stringBuffer.append(TEXT_921);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_922);
    stringBuffer.append(column.getName());
    
                            count++;
                        }
                    }
            if(isDynamic) {
                    Column dynamicColumn = getColumn(getDynamicColumn());
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                if("Dynamic".equals(typeToGenerate)) {
                
    stringBuffer.append(TEXT_923);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_924);
    stringBuffer.append(dynamicColumn.getName());
    
                }
                }
                    
    stringBuffer.append(TEXT_925);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_926);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_927);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_928);
    
            if(isDynamic) {

    stringBuffer.append(TEXT_929);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_930);
    
            }

    stringBuffer.append(TEXT_931);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_932);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_933);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_934);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_935);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_936);
     if(onErrDie){
    stringBuffer.append(TEXT_937);
     }else{
                             dbLog.logPrintedException("e.getMessage()");
    stringBuffer.append(TEXT_938);
    }
    stringBuffer.append(TEXT_939);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_940);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_941);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_942);
    
                } else if ("MYSQL_5".equals(dbVersion) || "MARIADB".equals(dbVersion)) {
                    int counter = 1;
                    for(Column column : colStruct) {
                        if(column.isInsertable()) {
                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                            
    stringBuffer.append(TEXT_943);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                            if(isEnableDebug) {
                                
    stringBuffer.append(TEXT_944);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_945);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_946);
    
                            }
                            counter++;
                        }

                    }
                    if(isDynamic) {
                        Column dynamicColumn = getColumn(getDynamicColumn());
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                        if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_947);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_948);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_949);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_950);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_951);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_952);
    
                        }
                        if("Dynamic".equals(typeToGenerate)) {
                        
    stringBuffer.append(TEXT_953);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_954);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_955);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_956);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_957);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_958);
    
                        }
                    }

                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_959);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_960);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_961);
    
                    }
                    
    if (rejectConnName == null) { // modification one
                    
    stringBuffer.append(TEXT_962);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_963);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_964);
    dbLog.data().addingToBatch(dbLog.var("nb_line"), dbLog.str(dataAction));
    
                        if (!("").equals(numPerInsert ) && !("0").equals(numPerInsert )) {
                      
    stringBuffer.append(TEXT_965);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_966);
    
                        }
                        
    
                    }else {
                    
    stringBuffer.append(TEXT_967);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_968);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_969);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_971);
    dbLog.data().inserting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_973);
    
                        if (("true").equals(dieOnError)) {
                            
    stringBuffer.append(TEXT_974);
    
                        } else {
                            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_975);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_976);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_977);
    
                                for(IMetadataColumn column : columnList) {
                                 
    stringBuffer.append(TEXT_978);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_979);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_980);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_981);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_982);
    
                                }
                                
    stringBuffer.append(TEXT_983);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_984);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_985);
    stringBuffer.append(TEXT_986);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_987);
    stringBuffer.append(TEXT_988);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_989);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_990);
    
                            } else {
                                dbLog.logPrintedException("e.getMessage()");
                                
    stringBuffer.append(TEXT_991);
    
                            }
                        }
                        
    stringBuffer.append(TEXT_992);
    
                }
                
    
                }
            } else {//extended-insert mode(end)
                int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_993);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_994);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_995);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_996);
    
                        }
                        counter++;
                    }

                }

                if(isDynamic) {
                    Column dynamicColumn = getColumn(getDynamicColumn());
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                    if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_997);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_998);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_999);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1002);
    
                    }
                    if("Dynamic".equals(typeToGenerate)) {
                    
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1008);
    
                    }
                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1011);
    
                }
                
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1016);
    dbLog.data().inserting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1018);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1019);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1022);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1027);
    
                            }
                            
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1035);
    
                        } else {
                            dbLog.logPrintedException("e.getMessage()");
                            
    stringBuffer.append(TEXT_1036);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_1037);
    
            }
        } else if(("UPDATE").equals(dataAction)) {
            int counterCol = 1;
            for(Column column : colStruct) {
                if(column.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1041);
    
                    }
                    counterCol++;
                }
            }
            if(isDynamic) {
                Column dynamicColumn = getColumn(getDynamicColumn());
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                if("Dynamic".equals(typeToGenerate)) {
                    if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(counterCol);
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1047);
    
                    }
                
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1054);
    
                }
            }

            for(Column column:colStruct){
                if(column.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_1055);
    
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) {
                if(isDynamic){
            
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(getManager(dbmsId, cid).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    
            }else{
            
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(getManager(dbmsId, cid).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    
            }
                    if(isEnableDebug) {
                        if(isDynamic){
                        
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1060);
    
                        }else{
                        
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1063);
    
                        }
                    }
                        counterCol++;
                       }
                     //#############
                    
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE, " + count_"));
    
                    if(isEnableDebug) {
                    if(isDynamic){
                    
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1067);
    
                    }else{
                    
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1070);
    
                    }
                    }
                    counterCol++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1073);
    
            }
            
    stringBuffer.append(TEXT_1074);
    if (rejectConnName == null && useBatchSize && ("MYSQL_5".equals(dbVersion) || "MARIADB".equals(dbVersion))) { // whether use batch
            
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1077);
    dbLog.data().addingToBatch(dbLog.var("nb_line"), dbLog.str(dataAction));
    
                if (useBatchSize && !("").equals(batchSize) && !("0").equals(batchSize)) {
              
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1079);
    
                }
                
    
            }else {
            
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1084);
    dbLog.data().updating(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1086);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1087);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1090);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1095);
    
                        }
                        
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1103);
    
                    } else {
                        dbLog.logPrintedException("e.getMessage()");
                        
    stringBuffer.append(TEXT_1104);
    
                    }
                }
                
    stringBuffer.append(TEXT_1105);
    
            } // end whether use batch
            
    
        } else if (("INSERT_OR_UPDATE").equals(dataAction)) {
            int columnIndex = 1;
            for(Column column : colStruct) {
                if(column.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    
    
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    
                        columnIndex++;
                       }
                     //#############
                    
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    
                    columnIndex++;
                }
            }
            
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1115);
    
                int counterCol = 1;
                for(Column column : colStruct) {
                    if(column.isUpdatable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1119);
    
                        }
                        counterCol++;
                    }
                }
                if(isDynamic) {
                    Column dynamicColumn = getColumn(getDynamicColumn());
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                    if("Dynamic".equals(typeToGenerate)) {
                        if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(counterCol);
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1125);
    
                        }
                        
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1132);
    
                    }
                }
                for(Column column : colStruct) {
                    if(column.isUpdateKey()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        String dbType = column.getColumn().getType();
                        
    
                        //#############for feature:2880
                        if(whereSupportNull && column.getColumn().isNullable()) {
                    if(isDynamic){
                
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(getManager(dbmsId, cid).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    
                }else{
                
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(getManager(dbmsId, cid).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    
                }
                             if(isEnableDebug) {
                                        if(isDynamic){
                            
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1137);
    
                            }else{
                            
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1140);
    
                            }
                            }
                            counterCol++;
                           }
                         //#############
                        
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    
                        if(isEnableDebug) {
                            if(isDynamic){
                        
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1144);
    
                        }else{
                        
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1147);
    
                        }
                        }
                        counterCol++;
                    }
                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1150);
    
                }
                
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1155);
    dbLog.data().updating(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1157);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1158);
    
                    } else {
                    
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1160);
    
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1163);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1168);
    
                            }
                            
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1176);
    
                        } else {
                            dbLog.logPrintedException("e.getMessage()");
                            
    stringBuffer.append(TEXT_1177);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_1178);
    
                int counterInsert = 1;
                for(Column columnInsert : colStruct)
                {
                    if(columnInsert.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnInsert, counterInsert, incomingConnName, cid, INSERT_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnInsert, incomingConnName, cid, "query_" ,  counterInsert, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1182);
    
                        }
                        counterInsert++;
                    }
                }
                if(isDynamic) {
                    Column dynamicColumn = getColumn(getDynamicColumn());
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                    if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(counterInsert);
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1188);
    
                    }
                    if("Dynamic".equals(typeToGenerate)) {
                    
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(counterInsert-1);
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1194);
    
                    }
                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1197);
    
                }
                
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1202);
    dbLog.data().inserting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1204);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1205);
    
                    } else {
                    
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1207);
    
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1210);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1215);
    
                            }
                            
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1223);
    
                        } else {
                            dbLog.logPrintedException("e.getMessage()");
                            
    stringBuffer.append(TEXT_1224);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_1225);
    
        } else if (("UPDATE_OR_INSERT").equals(dataAction)) {
            
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1227);
    
            int counterColUpdate = 1;
            for(Column columnUpdate : colStruct) {
                if(columnUpdate.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1231);
    
                    }
                    counterColUpdate++;
                }
            }
            if(isDynamic) {
                Column dynamicColumn = getColumn(getDynamicColumn());
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                if("Dynamic".equals(typeToGenerate)) {
                    if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(counterColUpdate);
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1237);
    
                    }
                    
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(counterColUpdate-1);
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1244);
    
                }
            }

            for(Column columnUpdate : colStruct) {
                if(columnUpdate.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
                    String dbType = columnUpdate.getColumn().getType();
                    
    
                    //#############for feature:2880 and 6980
                if(whereSupportNull && columnUpdate.getColumn().isNullable()) {
                    if(isDynamic){
                    
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(getManager(dbmsId, cid).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    
                    }else{
                    
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(getManager(dbmsId, cid).generateSetBooleanForNullableKeyStmt(columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    
                    }
                    if(isEnableDebug) {
                        if(isDynamic){
                        
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1249);
    
                        }else{
                        
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1252);
    
                        }
                    }
                    counterColUpdate++;
                       }
                     //#############
                    
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    
                    if(isEnableDebug) {
                        if(isDynamic){
                    
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1257);
    
                    }else{
                    
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1260);
    
                    }
                    }
                    counterColUpdate++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1263);
    
            }
            
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1270);
    
                if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1272);
    
                }
                int counter = 1;

                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, INSERT_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1276);
    
                        }
                        counter++;
                    }
                }
                if(isDynamic) {
                    Column dynamicColumn = getColumn(getDynamicColumn());
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                    if("Dynamic".equals(typeToGenerate)) {
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1282);
    
                            }
                        
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1288);
    
                    }
                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1291);
    
                }
                
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1296);
    dbLog.data().inserting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1298);
    dbLog.data().updating(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1300);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1301);
    
                    } else {
                    
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1303);
    
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1306);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1311);
    
                            }
                            
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1319);
    
                        } else {
                            dbLog.logPrintedException("e.getMessage()");
                            
    stringBuffer.append(TEXT_1320);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_1321);
    

        } else if (("DELETE").equals(dataAction)) {
            int keyCounter = 1;
            for(Column column : colStruct) {
                if(column.isDeleteKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    
    
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1325);
    
                            }
                         keyCounter++;
                       }
                     //#############
                    
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_"));
    stringBuffer.append(TEXT_1329);
    
                    }
                    keyCounter++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1332);
    
            }
            
    if (rejectConnName == null && useBatchSize && ("MYSQL_5".equals(dbVersion) || "MARIADB".equals(dbVersion))) { // whether use batch
            
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1335);
    dbLog.data().addingToBatch(dbLog.var("nb_line"), dbLog.str(dataAction));
    
                if (useBatchSize && !("").equals(batchSize) && !("0").equals(batchSize)) {
              
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1337);
    
                }
                
    
            }else {
            
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1342);
    dbLog.data().deleting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1344);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1345);
    
                } else {
                
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1347);
    
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1350);
    
                        for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1355);
    
                        }
                        
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1363);
    
                    } else {
                        dbLog.logPrintedException("e.getMessage()");
                        
    stringBuffer.append(TEXT_1364);
    
                    }
                }
                
    stringBuffer.append(TEXT_1365);
    
            } // end whether use batch
            
    
        } else if(("REPLACE").equals(dataAction)) {
            int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "replaceSQLSplits_"));
    stringBuffer.append(TEXT_1369);
    
                    }
                    counter++;
                }

            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1372);
    
            }
            
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1376);
    dbLog.data().replacing(null);
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1378);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1379);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1382);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1387);
    
                        }
                        
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1395);
    
                    } else {
                        dbLog.logPrintedException("e.getMessage()");
                        
    stringBuffer.append(TEXT_1396);
    
                    }
                }
                
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1403);
    
        } else if(("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {
            int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "insertIgnoreSQLSplits_"));
    stringBuffer.append(TEXT_1407);
    
                    }
                    counter++;
                }

            }
            for(Column column : colStruct) {
                if(column.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "insertIgnoreSQLSplits_"));
    stringBuffer.append(TEXT_1411);
    
                    }
                    counter++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1414);
    
            }
            
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1418);
    dbLog.data().insertingOnDuplicateKeyUpdating(null);
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1420);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1421);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1424);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1429);
    
                        }
                        
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1437);
    
                    } else {
                        dbLog.logPrintedException("e.getMessage()");
                        
    stringBuffer.append(TEXT_1438);
    
                    }
                }
                
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1445);
    
        }else if(("INSERT_IGNORE").equals(dataAction)) {
        int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1449);
    
                        }
                        counter++;
                    }

                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1452);
    
                }
                
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1457);
    dbLog.data().insertingIgnore(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1459);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1460);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1463);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1468);
    
                            }
                            
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1476);
    
                        } else {
                            dbLog.logPrintedException("e.getMessage()");
                            
    stringBuffer.append(TEXT_1477);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_1478);
    
        }


        if(outgoingConns != null && outgoingConns.size() > 0) {
            
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1480);
    
                for(IConnection outgoingConn : outgoingConns) {
                    if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                        if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

                            
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1483);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1488);
    
                            }
                        }
                    }
                }
            
    stringBuffer.append(TEXT_1489);
    
        }
            //////////batch execute by batch size///////
        if (extendedInsert && ("MYSQL_5".equals(dbVersion) || "MARIADB".equals(dbVersion)) && ("INSERT").equals(dataAction)) {
            if(!("").equals(numPerInsert ) && !("0").equals(numPerInsert )) {
            
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1492);
    if ( (rejectConnName==null)) {
                
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1494);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1499);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    if (("INSERT").equals(dataAction)) {
                        
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1502);
    
                        }
                        
    stringBuffer.append(TEXT_1503);
    if(("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1504);
    
                    }else {
                    
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1510);
    if (("INSERT").equals(dataAction)) {
                    
    stringBuffer.append(TEXT_1511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1513);
    
                    }
                    
    stringBuffer.append(TEXT_1514);
    
                    dbLog.logPrintedException("e.getMessage()");
                    }
    stringBuffer.append(TEXT_1515);
    
                }
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1517);
    
            }

        }
        if (useBatchSize && ("MYSQL_5".equals(dbVersion) || "MARIADB".equals(dbVersion)) &&(rejectConnName==null)&& (("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {
            if(!("").equals(batchSize) && !("0").equals(batchSize)) {
            
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1520);
    if (rejectConnName==null) {
                
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1522);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1528);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    
                         if (("UPDATE").equals(dataAction)) {
                        
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1531);
    
                        }else if (("DELETE").equals(dataAction)) {
                        
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1534);
    
                        }
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1536);
    if(("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1537);
    
                    }else {
                    
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1543);
    if (("UPDATE").equals(dataAction)) {
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1546);
     }else if (("DELETE").equals(dataAction)) {
    stringBuffer.append(TEXT_1547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1549);
    }
    stringBuffer.append(TEXT_1550);
    
                    dbLog.logPrintedException("e.getMessage()");
                    }
    stringBuffer.append(TEXT_1551);
    
                }
    stringBuffer.append(TEXT_1552);
    
            }

        }
        ////////////commit every////////////
        if(!("true").equals(useExistingConn)) {
            if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
                
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1556);
    if ((rejectConnName==null && useBatchSize && ("MYSQL_5".equals(dbVersion) || "MARIADB".equals(dbVersion))) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) ) {
                
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1558);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(("INSERT").equals(dataAction)? "1" : "countEach_" +cid);
    stringBuffer.append(TEXT_1564);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    if (("INSERT").equals(dataAction)) {
                        
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1567);
    
                        }else if (("UPDATE").equals(dataAction)) {
                        
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1570);
    
                        }else if (("DELETE").equals(dataAction)) {
                        
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1573);
    
                        }
    stringBuffer.append(TEXT_1574);
    if(("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1575);
    
                    }else {
                    
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1581);
    if (("INSERT").equals(dataAction)) {
                    
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1584);
    
                    }else if (("UPDATE").equals(dataAction)) {
                    
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1587);
    
                    }else if (("DELETE").equals(dataAction)) {
                    
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1590);
    
                    }
    stringBuffer.append(TEXT_1591);
    
                    dbLog.logPrintedException("e.getMessage()");
                    }
    stringBuffer.append(TEXT_1592);
    
                }
    dbLog.commit().commitTry(null, dbLog.var("commitCounter"));
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1594);
    dbLog.commit().commitDone(null);
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1596);
    
            }
        }
    }

    stringBuffer.append(TEXT_1597);
    return stringBuffer.toString();
  }
}
