เขียนขั้นตอนการรันเพื่อทดสอบใน Readme
ผมเขียน controller เพื่อจัดการ api ทั้งหมด 2 เส้นครับ
เส้นหลักคือ http://localhost:8080/Main-controller/gentoken คือเส้นสำหรับการเพิ่มข้อมูล (Insert)
เส้นรองคือ http://localhost:8080/Main-controller/get-data-user สำหรับเรียกข้อมูลทั้งหมดมาแสดงผล

โฟลเดอร์ทั้งหมด
1 controller สำหรับจัดการเส้น API
2 service รับการทำงานมาจาก controller
3 model เป็นค่าส่งผ่าน Entity
4 entity ร่างฐานข้อมูล
5 respon สำหรับการ return ค่า error
6 repository สำหรับการเชื่อมฐานข้อมูล

ในส่วนการทำสอบ 
1 การเพิ่ม ใส่ข้อมูล
{
  "ssoType": "SSOData",
  "systemId": "VATDEDEV",
  "systemName": "ระบบบันทึกข้อมูลภาษีมูลค่าเพิ่มทดสอบ",
  "systemTransactions": "PRIV-010,PRIV-020,PRIV-040,PRIV-050",
  "systemPrivileges": "0|0|0|0",
  "systemUserGroup": "GRP-010,GRP-020,GRP-040",
  "systemLocationGroup": "CliC001",
  "userId": "WS233999",
  "userFullName": "ประสาท จันทร์อังคาร",
  "userRdOfficeCode": "01000999",
  "userOfficeCode": "01001139",
  "clientLocation": "01001139",
  "locationMachineNumber": "CLI00000718-9999",
  "tokenId": "eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9",
  "requestDate": "2025-12-09T18:34:13.642Z"
}

จะได้ Responses
{
  "responseCode": "I07000",
  "responseMessage": "ทำรายการเรียบร้อย",
  "responseData": {
    "userId": "WS233999",
    "tokenId": "eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9"
  }
}

2 การจับ error 400 กรณีไม่พบข้อมูลการ POST
{
  "ssoType": null,
  "systemId": "string",
  "systemName": "string",
  "systemTransactions": "string",
  "systemPrivileges": "string",
  "systemUserGroup": "string",
  "systemLocationGroup": "string",
  "userId": "string",
  "userFullName": "string",
  "userRdOfficeCode": "string",
  "userOfficeCode": "string",
  "clientLocation": "string",
  "locationMachineNumber": "string",
  "tokenId": "string",
  "requestDate": "2025-12-09T18:38:31.586Z"
}

จะได้ Responses
{
  "responseCode": "E000400",
  "responseMessage": "ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้ เนื่องจากข้อมูลไม่ครบ",
  "responseData": {
    "userId": null,
    "tokenId": ""
  }
}

3 การจับ error 500 กรณีไม่พบข้อมูลการ POST
เปลี่ยน ข้อมูลใน folder MainEntity บรรทัดที่ 181
    @Id
    @Column(name = "request_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRequestDate() {
        return requestDate;
    }

เป็น
  @Id
  @Column(name = "request_date , nullable = false")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getRequestDate() {
    return requestDate;
  }
และ รัน swagger ในส่วน insert

จะได้ Responses
{
  "responseCode": "E000500",
  "responseMessage": "ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้  เนื่องจากไม่พบฐานข้อมูล",
  "responseData": {
    "userId": "string",
    "tokenId": ""
  }
}
