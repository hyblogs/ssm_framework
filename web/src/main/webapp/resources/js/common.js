//防止右击弹出菜单
// document.oncontextmenu = function(e) { return false; }
//定义每页数据量
var PAGESIZE = 10;

/**
 * 判断目标对象是否为空
 * @param obj 要判断的目标对象
 * @returns {boolean}
 */
function isEmpty(obj) {
    if(obj === undefined) { // 只能用 === 运算来测试某个值是否是未定义的
        return true;
    }
    if(obj == null) { // 等同于 obj === undefined || obj === null
        return true;
    }
    if(obj === ""){ // "",null,undefined
        return true;
    }
    if(!obj){ // "",null,undefined,NobjN
        return true;
    }
    if(!$.trim(obj)){ // "",null,undefined
        return true;
    }
    if (obj instanceof Array) {
        if(obj.length === 0){ // "",[]
            return true;
        }
        if(!obj.length){ // "",[]
            return true;
        }
    }
    if (obj instanceof Object) {
        // 普通对象使用 for...in 判断，有 key 即为 fobjlse
        if($.isEmptyObject(obj)){
            return true;
        }
    }
    return false;
}