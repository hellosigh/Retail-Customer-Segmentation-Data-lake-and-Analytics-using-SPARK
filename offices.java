// ORM class for table 'offices'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Fri Jun 09 01:45:38 IST 2017
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

public class offices extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private String officeCode;
  public String get_officeCode() {
    return officeCode;
  }
  public void set_officeCode(String officeCode) {
    this.officeCode = officeCode;
  }
  public offices with_officeCode(String officeCode) {
    this.officeCode = officeCode;
    return this;
  }
  private String city;
  public String get_city() {
    return city;
  }
  public void set_city(String city) {
    this.city = city;
  }
  public offices with_city(String city) {
    this.city = city;
    return this;
  }
  private String phone;
  public String get_phone() {
    return phone;
  }
  public void set_phone(String phone) {
    this.phone = phone;
  }
  public offices with_phone(String phone) {
    this.phone = phone;
    return this;
  }
  private String addressLine1;
  public String get_addressLine1() {
    return addressLine1;
  }
  public void set_addressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }
  public offices with_addressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }
  private String addressLine2;
  public String get_addressLine2() {
    return addressLine2;
  }
  public void set_addressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }
  public offices with_addressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }
  private String state;
  public String get_state() {
    return state;
  }
  public void set_state(String state) {
    this.state = state;
  }
  public offices with_state(String state) {
    this.state = state;
    return this;
  }
  private String country;
  public String get_country() {
    return country;
  }
  public void set_country(String country) {
    this.country = country;
  }
  public offices with_country(String country) {
    this.country = country;
    return this;
  }
  private String postalCode;
  public String get_postalCode() {
    return postalCode;
  }
  public void set_postalCode(String postalCode) {
    this.postalCode = postalCode;
  }
  public offices with_postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }
  private String territory;
  public String get_territory() {
    return territory;
  }
  public void set_territory(String territory) {
    this.territory = territory;
  }
  public offices with_territory(String territory) {
    this.territory = territory;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof offices)) {
      return false;
    }
    offices that = (offices) o;
    boolean equal = true;
    equal = equal && (this.officeCode == null ? that.officeCode == null : this.officeCode.equals(that.officeCode));
    equal = equal && (this.city == null ? that.city == null : this.city.equals(that.city));
    equal = equal && (this.phone == null ? that.phone == null : this.phone.equals(that.phone));
    equal = equal && (this.addressLine1 == null ? that.addressLine1 == null : this.addressLine1.equals(that.addressLine1));
    equal = equal && (this.addressLine2 == null ? that.addressLine2 == null : this.addressLine2.equals(that.addressLine2));
    equal = equal && (this.state == null ? that.state == null : this.state.equals(that.state));
    equal = equal && (this.country == null ? that.country == null : this.country.equals(that.country));
    equal = equal && (this.postalCode == null ? that.postalCode == null : this.postalCode.equals(that.postalCode));
    equal = equal && (this.territory == null ? that.territory == null : this.territory.equals(that.territory));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof offices)) {
      return false;
    }
    offices that = (offices) o;
    boolean equal = true;
    equal = equal && (this.officeCode == null ? that.officeCode == null : this.officeCode.equals(that.officeCode));
    equal = equal && (this.city == null ? that.city == null : this.city.equals(that.city));
    equal = equal && (this.phone == null ? that.phone == null : this.phone.equals(that.phone));
    equal = equal && (this.addressLine1 == null ? that.addressLine1 == null : this.addressLine1.equals(that.addressLine1));
    equal = equal && (this.addressLine2 == null ? that.addressLine2 == null : this.addressLine2.equals(that.addressLine2));
    equal = equal && (this.state == null ? that.state == null : this.state.equals(that.state));
    equal = equal && (this.country == null ? that.country == null : this.country.equals(that.country));
    equal = equal && (this.postalCode == null ? that.postalCode == null : this.postalCode.equals(that.postalCode));
    equal = equal && (this.territory == null ? that.territory == null : this.territory.equals(that.territory));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.officeCode = JdbcWritableBridge.readString(1, __dbResults);
    this.city = JdbcWritableBridge.readString(2, __dbResults);
    this.phone = JdbcWritableBridge.readString(3, __dbResults);
    this.addressLine1 = JdbcWritableBridge.readString(4, __dbResults);
    this.addressLine2 = JdbcWritableBridge.readString(5, __dbResults);
    this.state = JdbcWritableBridge.readString(6, __dbResults);
    this.country = JdbcWritableBridge.readString(7, __dbResults);
    this.postalCode = JdbcWritableBridge.readString(8, __dbResults);
    this.territory = JdbcWritableBridge.readString(9, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.officeCode = JdbcWritableBridge.readString(1, __dbResults);
    this.city = JdbcWritableBridge.readString(2, __dbResults);
    this.phone = JdbcWritableBridge.readString(3, __dbResults);
    this.addressLine1 = JdbcWritableBridge.readString(4, __dbResults);
    this.addressLine2 = JdbcWritableBridge.readString(5, __dbResults);
    this.state = JdbcWritableBridge.readString(6, __dbResults);
    this.country = JdbcWritableBridge.readString(7, __dbResults);
    this.postalCode = JdbcWritableBridge.readString(8, __dbResults);
    this.territory = JdbcWritableBridge.readString(9, __dbResults);
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
    JdbcWritableBridge.writeString(officeCode, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(city, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(phone, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(addressLine1, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(addressLine2, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(state, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(country, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(postalCode, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(territory, 9 + __off, 12, __dbStmt);
    return 9;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(officeCode, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(city, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(phone, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(addressLine1, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(addressLine2, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(state, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(country, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(postalCode, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(territory, 9 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.officeCode = null;
    } else {
    this.officeCode = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.city = null;
    } else {
    this.city = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.phone = null;
    } else {
    this.phone = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.addressLine1 = null;
    } else {
    this.addressLine1 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.addressLine2 = null;
    } else {
    this.addressLine2 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.state = null;
    } else {
    this.state = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.country = null;
    } else {
    this.country = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.postalCode = null;
    } else {
    this.postalCode = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.territory = null;
    } else {
    this.territory = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.officeCode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, officeCode);
    }
    if (null == this.city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, city);
    }
    if (null == this.phone) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, phone);
    }
    if (null == this.addressLine1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, addressLine1);
    }
    if (null == this.addressLine2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, addressLine2);
    }
    if (null == this.state) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, state);
    }
    if (null == this.country) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, country);
    }
    if (null == this.postalCode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, postalCode);
    }
    if (null == this.territory) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, territory);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.officeCode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, officeCode);
    }
    if (null == this.city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, city);
    }
    if (null == this.phone) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, phone);
    }
    if (null == this.addressLine1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, addressLine1);
    }
    if (null == this.addressLine2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, addressLine2);
    }
    if (null == this.state) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, state);
    }
    if (null == this.country) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, country);
    }
    if (null == this.postalCode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, postalCode);
    }
    if (null == this.territory) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, territory);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 126, (char) 10, (char) 0, (char) 0, false);
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
    __sb.append(FieldFormatter.escapeAndEnclose(officeCode==null?"null":officeCode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city==null?"null":city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(phone==null?"null":phone, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(addressLine1==null?"null":addressLine1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(addressLine2==null?"null":addressLine2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(state==null?"null":state, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(country==null?"null":country, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(postalCode==null?"null":postalCode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(territory==null?"null":territory, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(officeCode==null?"null":officeCode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city==null?"null":city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(phone==null?"null":phone, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(addressLine1==null?"null":addressLine1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(addressLine2==null?"null":addressLine2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(state==null?"null":state, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(country==null?"null":country, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(postalCode==null?"null":postalCode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(territory==null?"null":territory, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 126, (char) 10, (char) 0, (char) 0, false);
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
    if (__cur_str.equals("null")) { this.officeCode = null; } else {
      this.officeCode = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.city = null; } else {
      this.city = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.phone = null; } else {
      this.phone = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.addressLine1 = null; } else {
      this.addressLine1 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.addressLine2 = null; } else {
      this.addressLine2 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.state = null; } else {
      this.state = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.country = null; } else {
      this.country = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.postalCode = null; } else {
      this.postalCode = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.territory = null; } else {
      this.territory = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.officeCode = null; } else {
      this.officeCode = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.city = null; } else {
      this.city = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.phone = null; } else {
      this.phone = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.addressLine1 = null; } else {
      this.addressLine1 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.addressLine2 = null; } else {
      this.addressLine2 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.state = null; } else {
      this.state = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.country = null; } else {
      this.country = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.postalCode = null; } else {
      this.postalCode = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.territory = null; } else {
      this.territory = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    offices o = (offices) super.clone();
    return o;
  }

  public void clone0(offices o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("officeCode", this.officeCode);
    __sqoop$field_map.put("city", this.city);
    __sqoop$field_map.put("phone", this.phone);
    __sqoop$field_map.put("addressLine1", this.addressLine1);
    __sqoop$field_map.put("addressLine2", this.addressLine2);
    __sqoop$field_map.put("state", this.state);
    __sqoop$field_map.put("country", this.country);
    __sqoop$field_map.put("postalCode", this.postalCode);
    __sqoop$field_map.put("territory", this.territory);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("officeCode", this.officeCode);
    __sqoop$field_map.put("city", this.city);
    __sqoop$field_map.put("phone", this.phone);
    __sqoop$field_map.put("addressLine1", this.addressLine1);
    __sqoop$field_map.put("addressLine2", this.addressLine2);
    __sqoop$field_map.put("state", this.state);
    __sqoop$field_map.put("country", this.country);
    __sqoop$field_map.put("postalCode", this.postalCode);
    __sqoop$field_map.put("territory", this.territory);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("officeCode".equals(__fieldName)) {
      this.officeCode = (String) __fieldVal;
    }
    else    if ("city".equals(__fieldName)) {
      this.city = (String) __fieldVal;
    }
    else    if ("phone".equals(__fieldName)) {
      this.phone = (String) __fieldVal;
    }
    else    if ("addressLine1".equals(__fieldName)) {
      this.addressLine1 = (String) __fieldVal;
    }
    else    if ("addressLine2".equals(__fieldName)) {
      this.addressLine2 = (String) __fieldVal;
    }
    else    if ("state".equals(__fieldName)) {
      this.state = (String) __fieldVal;
    }
    else    if ("country".equals(__fieldName)) {
      this.country = (String) __fieldVal;
    }
    else    if ("postalCode".equals(__fieldName)) {
      this.postalCode = (String) __fieldVal;
    }
    else    if ("territory".equals(__fieldName)) {
      this.territory = (String) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("officeCode".equals(__fieldName)) {
      this.officeCode = (String) __fieldVal;
      return true;
    }
    else    if ("city".equals(__fieldName)) {
      this.city = (String) __fieldVal;
      return true;
    }
    else    if ("phone".equals(__fieldName)) {
      this.phone = (String) __fieldVal;
      return true;
    }
    else    if ("addressLine1".equals(__fieldName)) {
      this.addressLine1 = (String) __fieldVal;
      return true;
    }
    else    if ("addressLine2".equals(__fieldName)) {
      this.addressLine2 = (String) __fieldVal;
      return true;
    }
    else    if ("state".equals(__fieldName)) {
      this.state = (String) __fieldVal;
      return true;
    }
    else    if ("country".equals(__fieldName)) {
      this.country = (String) __fieldVal;
      return true;
    }
    else    if ("postalCode".equals(__fieldName)) {
      this.postalCode = (String) __fieldVal;
      return true;
    }
    else    if ("territory".equals(__fieldName)) {
      this.territory = (String) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
