
function fnAbc() {
    const abc = require('./everquest')
    console.log("===", abc)
    console.log("===", abc.xyz.sfx.base64)
    console.log("===测试base64编码", abc.xyz.sfx.base64.Base64Factory.createEncoder().encodeToString("哈哈哈哈"))
}
fnAbc()
