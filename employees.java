// ORM class for table 'employees'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Fri Jun 09 01:43:05 IST 2017
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class employees extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private Integer employeeNumber;
  public Integer get_employeeNumber() {
    return employeeNumber;
  }
  public void set_employeeNumber(Integer employeeNumber) {
    this.employeeNumber = employeeNumber;
  }
  public employees with_employeeNumber(Integer employeeNumber) {
    this.employeeNumber = employeeNumber;
    return this;
  }
  private String lastName;
  public String get_lastName() {
    return lastName;
  }
  public void set_lastName(String lastName) {
    this.lastName = lastName;
  }
  public employees with_lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
  private String firstName;
  public String get_firstName() {
    return firstName;
  }
  public void set_firstName(String firstName) {
    this.firstName = firstName;
  }
  public employees with_firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }
  private String extension;
  public String get_extension() {
    return extension;
  }
  public void set_extension(String extension) {
    this.extension = extension;
  }
  public employees with_extension(String extension) {
    this.extension = extension;
    return this;
  }
  private String email;
  public String get_email() {
    return email;
  }
  public void set_email(String email) {
    this.email = email;
  }
  public employees with_email(String email) {
    this.email = email;
    return this;
  }
  private String officeCode;
  public String get_officeCode() {
    return officeCode;
  }
  public void set_officeCode(String officeCode) {
    this.officeCode = officeCode;
  }
  public employees with_officeCode(String officeCode) {
    this.officeCode = officeCode;
    return this;
  }
  private Integer reportsTo;
  public Integer get_reportsTo() {
    return reportsTo;
  }
  public void set_reportsTo(Integer reportsTo) {
    this.reportsTo = reportsTo;
  }
  public employees with_reportsTo(Integer reportsTo) {
    this.reportsTo = reportsTo;
    return this;
  }
  private String jobTitle;
  public String get_jobTitle() {
    return jobTitle;
  }
  public void set_jobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }
  public employees with_jobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof employees)) {
      return false;
    }
    employees that = (employees) o;
    boolean equal = true;
    equal = equal && (this.employeeNumber == null ? that.employeeNumber == null : this.employeeNumber.equals(that.employeeNumber));
    equal = equal && (this.lastName == null ? that.lastName == null : this.lastName.equals(that.lastName));
    equal = equal && (this.firstName == null ? that.firstName == null : this.firstName.equals(that.firstName));
    equal = equal && (this.extension == null ? that.extension == null : this.extension.equals(that.extension));
    equal = equal && (this.email == null ? that.email == null : this.email.equals(that.email));
    equal = equal && (this.officeCode == null ? that.officeCode == null : this.officeCode.equals(that.officeCode));
    equal = equal && (this.reportsTo == null ? that.reportsTo == null : this.reportsTo.equals(that.reportsTo));
    equal = equal && (this.jobTitle == null ? that.jobTitle == null : this.jobTitle.equals(that.jobTitle));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof employees)) {
      return false;
    }
    employees that = (employees) o;
    boolean equal = true;
    equal = equal && (this.employeeNumber == null ? that.employeeNumber == null : this.employeeNumber.equals(that.employeeNumber));
    equal = equal && (this.lastName == null ? that.lastName == null : this.lastName.equals(that.lastName));
    equal = equal && (this.firstName == null ? that.firstName == null : this.firstName.equals(that.firstName));
    equal = equal && (this.extension == null ? that.extension == null : this.extension.equals(that.extension));
    equal = equal && (this.email == null ? that.email == null : this.email.equals(that.email));
    equal = equal && (this.officeCode == null ? that.officeCode == null : this.officeCode.equals(that.officeCode));
    equal = equal && (this.reportsTo == null ? that.reportsTo == null : this.reportsTo.equals(that.reportsTo));
    equal = equal && (this.jobTitle == null ? that.jobTitle == null : this.jobTitle.equals(that.jobTitle));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.employeeNumber = JdbcWritableBridge.readInteger(1, __dbResults);
    this.lastName = JdbcWritableBridge.readString(2, __dbResults);
    this.firstName = JdbcWritableBridge.readString(3, __dbResults);
    this.extension = JdbcWritableBridge.readString(4, __dbResults);
    this.email = JdbcWritableBridge.readString(5, __dbResults);
    this.officeCode = JdbcWritableBridge.readString(6, __dbResults);
    this.reportsTo = JdbcWritableBridge.readInteger(7, __dbResults);
    this.jobTitle = JdbcWritableBridge.readString(8, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.employeeNumber = JdbcWritableBridge.readInteger(1, __dbResults);
    this.lastName = JdbcWritableBridge.readString(2, __dbResults);
    this.firstName = JdbcWritableBridge.readString(3, __dbResults);
    this.extension = JdbcWritableBridge.readString(4, __dbResults);
    this.email = JdbcWritableBridge.readString(5, __dbResults);
    this.officeCode = JdbcWritableBridge.readString(6, __dbResults);
    this.reportsTo = JdbcWritableBridge.readInteger(7, __dbResults);
    this.jobTitle = JdbcWritableBridge.readString(8, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(employeeNumber, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(lastName, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(firstName, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(extension, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(email, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(officeCode, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(reportsTo, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(jobTitle, 8 + __off, 12, __dbStmt);
    return 8;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(employeeNumber, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(lastName, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(firstName, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(extension, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(email, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(officeCode, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(reportsTo, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(jobTitle, 8 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.employeeNumber = null;
    } else {
    this.employeeNumber = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.lastName = null;
    } else {
    this.lastName = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.firstName = null;
    } else {
    this.firstName = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.extension = null;
    } else {
    this.extension = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.email = null;
    } else {
    this.email = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.officeCode = null;
    } else {
    this.officeCode = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.reportsTo = null;
    } else {
    this.reportsTo = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.jobTitle = null;
    } else {
    this.jobTitle = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.employeeNumber) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.employeeNumber);
    }
    if (null == this.lastName) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, lastName);
    }
    if (null == this.firstName) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, firstName);
    }
    if (null == this.extension) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, extension);
    }
    if (null == this.email) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, email);
    }
    if (null == this.officeCode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, officeCode);
    }
    if (null == this.reportsTo) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reportsTo);
    }
    if (null == this.jobTitle) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, jobTitle);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.employeeNumber) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.employeeNumber);
    }
    if (null == this.lastName) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, lastName);
    }
    if (null == this.firstName) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, firstName);
    }
    if (null == this.extension) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, extension);
    }
    if (null == this.email) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, email);
    }
    if (null == this.officeCode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, officeCode);
    }
    if (null == this.reportsTo) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reportsTo);
    }
    if (null == this.jobTitle) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, jobTitle);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(employeeNumber==null?"null":"" + employeeNumber, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(lastName==null?"null":lastName, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(firstName==null?"null":firstName, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(extension==null?"null":extension, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(email==null?"null":email, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(officeCode==null?"null":officeCode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reportsTo==null?"null":"" + reportsTo, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(jobTitle==null?"null":jobTitle, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(employeeNumber==null?"null":"" + employeeNumber, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(lastName==null?"null":lastName, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(firstName==null?"null":firstName, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(extension==null?"null":extension, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(email==null?"null":email, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(officeCode==null?"null":officeCode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reportsTo==null?"null":"" + reportsTo, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(jobTitle==null?"null":jobTitle, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.employeeNumber = null; } else {
      this.employeeNumber = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.lastName = null; } else {
      this.lastName = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.firstName = null; } else {
      this.firstName = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.extension = null; } else {
      this.extension = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.email = null; } else {
      this.email = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.officeCode = null; } else {
      this.officeCode = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reportsTo = null; } else {
      this.reportsTo = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.jobTitle = null; } else {
      this.jobTitle = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.employeeNumber = null; } else {
      this.employeeNumber = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.lastName = null; } else {
      this.lastName = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.firstName = null; } else {
      this.firstName = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.extension = null; } else {
      this.extension = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.email = null; } else {
      this.email = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.officeCode = null; } else {
      this.officeCode = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reportsTo = null; } else {
      this.reportsTo = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.jobTitle = null; } else {
      this.jobTitle = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    employees o = (employees) super.clone();
    return o;
  }

  public void clone0(employees o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("employeeNumber", this.employeeNumber);
    __sqoop$field_map.put("lastName", this.lastName);
    __sqoop$field_map.put("firstName", this.firstName);
    __sqoop$field_map.put("extension", this.extension);
    __sqoop$field_map.put("email", this.email);
    __sqoop$field_map.put("officeCode", this.officeCode);
    __sqoop$field_map.put("reportsTo", this.reportsTo);
    __sqoop$field_map.put("jobTitle", this.jobTitle);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("employeeNumber", this.employeeNumber);
    __sqoop$field_map.put("lastName", this.lastName);
    __sqoop$field_map.put("firstName", this.firstName);
    __sqoop$field_map.put("extension", this.extension);
    __sqoop$field_map.put("email", this.email);
    __sqoop$field_map.put("officeCode", this.officeCode);
    __sqoop$field_map.put("reportsTo", this.reportsTo);
    __sqoop$field_map.put("jobTitle", this.jobTitle);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("employeeNumber".equals(__fieldName)) {
      this.employeeNumber = (Integer) __fieldVal;
    }
    else    if ("lastName".equals(__fieldName)) {
      this.lastName = (String) __fieldVal;
    }
    else    if ("firstName".equals(__fieldName)) {
      this.firstName = (String) __fieldVal;
    }
    else    if ("extension".equals(__fieldName)) {
      this.extension = (String) __fieldVal;
    }
    else    if ("email".equals(__fieldName)) {
      this.email = (String) __fieldVal;
    }
    else    if ("officeCode".equals(__fieldName)) {
      this.officeCode = (String) __fieldVal;
    }
    else    if ("reportsTo".equals(__fieldName)) {
      this.reportsTo = (Integer) __fieldVal;
    }
    else    if ("jobTitle".equals(__fieldName)) {
      this.jobTitle = (String) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("employeeNumber".equals(__fieldName)) {
      this.employeeNumber = (Integer) __fieldVal;
      return true;
    }
    else    if ("lastName".equals(__fieldName)) {
      this.lastName = (String) __fieldVal;
      return true;
    }
    else    if ("firstName".equals(__fieldName)) {
      this.firstName = (String) __fieldVal;
      return true;
    }
    else    if ("extension".equals(__fieldName)) {
      this.extension = (String) __fieldVal;
      return true;
    }
    else    if ("email".equals(__fieldName)) {
      this.email = (String) __fieldVal;
      return true;
    }
    else    if ("officeCode".equals(__fieldName)) {
      this.officeCode = (String) __fieldVal;
      return true;
    }
    else    if ("reportsTo".equals(__fieldName)) {
      this.reportsTo = (Integer) __fieldVal;
      return true;
    }
    else    if ("jobTitle".equals(__fieldName)) {
      this.jobTitle = (String) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
