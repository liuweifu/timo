!function () {
    var j = document.createElement("ins");
    j.id = "newBridge";
    if (document.getElementById(j.id)) {
        return
    }
    var b = [{
        "inviteBox": {
            "startPage": 1,
            "skinIndex": 0,
            "customerStyle": {"acceptFontColor": "#000000", "backImg": "", "acceptBgColor": "#fecb2e"},
            "defaultStyle": 1,
            "likeCrm": 0,
            "skinName": "默认皮肤",
            "autoHide": 0,
            "reInvite": 1,
            "sendButton": {"bgColor": "#bfecff", "fontColor": "#1980df"},
            "isShowText": 1,
            "license": "000",
            "skinType": 1,
            "buttonType": 1,
            "autoInvite": 1,
            "stayTime": 6,
            "closeTime": 20,
            "width": 400,
            "isCustomerStyle": 0,
            "position": "middle",
            "inviteInterval": 30,
            "welcome": "<p style=\"color: #fff\">欢迎来到本网站，请问有什么可以帮您？</p>",
            "tradeId": 0,
            "height": 175
        },
        "webimConfig": {
            "isShowIntelWelLan": 0,
            "license": "000",
            "isOpenAutoDirectCom": 0,
            "skinIndex": 0,
            "skinType": 1,
            "waitVisitStayTime": 6
        },
        "noteBoard": {
            "skinIndex": 0,
            "likeCrm": 1,
            "displayCompany": 0,
            "customerColor": "#00aef3",
            "cpyInfo": "",
            "skinName": "默认皮肤",
            "displayLxb": 1,
            "skinType": 1,
            "position": "right-bottom",
            "itemsExt": [],
            "items": [{"name": "visitorName", "required": 0, "isShow": 1}, {
                "name": "visitorPhone",
                "required": 1,
                "isShow": 1
            }, {"name": "visitorEmail", "required": 0, "isShow": 1}, {
                "name": "visitorAddress",
                "required": 0,
                "isShow": 1
            }],
            "cpyTel": "",
            "needVerifyCode": 1,
            "tradeId": 0,
            "isAlwaysDisplay": 0
        },
        "isWebim": 1,
        "pageId": 0,
        "seekIcon": {
            "customerStyle": {"backImg": ""},
            "skinIndex": 0,
            "likeCrm": 0,
            "skinName": "默认皮肤",
            "groups": [{"groupName": "示例分组1", "groupId": 751873}],
            "displayLxb": 1,
            "cpyInfo": "",
            "marginLeft": 0,
            "skinType": 1,
            "isFixedPosition": 1,
            "iconType": 0,
            "isCustomerStyle": 0,
            "width": 144,
            "groupStyle": {"bgColor": "#ffffff", "buttonColor": "#d6f3ff", "fontColor": "#008edf"},
            "position": "right-top",
            "marginTop": 0,
            "tradeId": 0,
            "height": 52
        }
    }], l = {
        "eid": "29429585",
        "queuing": "<p>欢迎光临！您已经进入服务队列，请您稍候，马上为您转接您的在线咨询顾问。</p>",
        "session": {
            "displayName": "d**1",
            "headUrl": "https://ss0.bdstatic.com/7Ls0a8Sm1A5BphGlnYG/sys/portraitn/item/077d6466673132313131319f09.jpg",
            "status": 0,
            "uid": 0,
            "uname": ""
        },
        "authToken": "bridge",
        "isWebim": 1,
        "imVersion": "im_server",
        "platform": 0,
        "isGray": "false",
        "webimConfig": {
            "isShowIntelWelLan": 0,
            "license": "000",
            "isOpenAutoDirectCom": 0,
            "skinIndex": 0,
            "skinType": 1,
            "waitVisitStayTime": 6
        },
        "isOpenRobot": 0,
        "authType": 4,
        "prologue": "",
        "isPreonline": 0,
        "timestamp": 1598189895078,
        "isCsOnline": 0,
        "siteToken": "5d5bfadcd708563358f6600c01fdcfaf",
        "userId": "29429585",
        "wsUrl": "wss://p.qiao.baidu.com/cps4/websocket",
        "route": "1",
        "csrfToken": "37318a4ca00442298da2522d66d929f1",
        "likeVersion": "generic",
        "siteId": "14779029",
        "online": "false",
        "bid": "1614471750014779029",
        "webRoot": "//p.qiao.baidu.com/cps4/",
        "isSmallFlow": 0
    }, m = [];

    function h() {
        var p = window.location.href, o = 0, n = null;
        if (m) {
            for (var i = 0, g = m.length; i < g; i++) {
                if (m[i].url === p) {
                    o = m[i].pageId;
                    break
                }
            }
            if (o === 0) {
                for (var i = 0, g = m.length; i < g; i++) {
                    if (-1 < p.indexOf(m[i].url)) {
                        o = m[i].pageId;
                        break
                    }
                }
            }
        }
        l.pageId = o;
        i = 0;
        for (g = b.length; i < g; i++) {
            if (b[i].pageId === o) {
                f = b[i].webimConfig;
                l.webimConfig = {skinIndex: f.skinIndex, skinType: f.skinType};
                return b[i]
            }
            0 === b[i].pageId && (n = b[i])
        }
        return n
    }

    j.config = h(), j.siteConfig = l, j.startTime = +new Date;
    j.deferOnce = {
        on: function (e) {
            this.done ? e() : this.callback = e
        }, emit: function () {
            this.callback ? this.callback() : (this.done = true)
        }
    };
    var k = document.getElementsByTagName("script")[0];
    k.parentNode.insertBefore(j, k);

    function c() {
        if (document.body) {
            document.body.insertBefore(j, document.body.firstElement || null);
            j.deferOnce.emit()
        } else {
            setTimeout(c, 0)
        }
    }

    c();
    var d = document.createElement("script");
    d.src = "//sgoutong.baidu.com/embed/1588057042/asset/embed/pc_nb.js", d.setAttribute("charset", "UTF-8");
    var a = document.getElementsByTagName("head")[0] || document.body;
    a.insertBefore(d, a.firstElement || null);
    var moreSided = function () {
        return
    };
    moreSided.prototype.data = {startTime: new Date().getTime()};
    moreSided.prototype.init = function () {
        var that = this;
        var dbody = document.body;
        if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
            dbody.ontouchstart = function (e) {
                that.handle(e)
            }
        } else {
            dbody.onclick = function (e) {
                that.handle(e)
            }
        }
    };
    moreSided.prototype.handle = function (e) {
        var that = this;
        var path = e.path;
        if (path && path.length > 0) {
            path.length = path.length - 4;
            var data = that.processing(path);
            if (data) {
                data.duration = new Date().getTime() - that.data.startTime;
                that.sendImg(data)
            }
        }
    };
    moreSided.prototype.processing = function (path) {
        var data = {text: "", uid: l.userId, siteid: l.siteId, bid: l.bid, qType: "m9001"};
        for (var i = 0; i < path.length; i++) {
            if (data.text.length === 0 && path[i].innerText.length > 0 && path[i].innerText.length < 30) {
                data.text = path[i].innerText
            }
            if (path[i].tagName === "A") {
                if (path[i].hash.length > 0 && path[i].hash[0] === "#") {
                    data.type = 2
                } else {
                    if (path[i].href.indexOf("javascript:;") > -1) {
                        data.type = 4
                    } else {
                        data.type = 1
                    }
                }
                if (path[i].innerText.length > 0) {
                    data.text = path[i].innerText
                }
                if (data.text.length === 0 && path[i].firstElementChild && path[i].firstElementChild.tagName === "IMG") {
                    if (path[i].firstElementChild.alt.length > 0) {
                        data.text = path[i].firstElementChild.alt
                    } else {
                        data.text = "imgLink"
                    }
                }
                return data
            } else {
                data.type = 4
            }
        }
        if (data.text.length === 0) {
            return false
        }
        return data
    };
    moreSided.prototype.sendImg = function (params) {
        var url = "//sgoutong.baidu.com/eye/log/js/stat.gif?";
        var img = document.createElement("img");
        url += this.jsonToQuery(params);
        img.src = url
    };
    moreSided.prototype.jsonToQuery = function (data) {
        var obj = data;
        var urlParams = "";
        for (var i in obj) {
            urlParams += (i + "=" + encodeURIComponent(obj[i]) + "&")
        }
        urlParams = urlParams.substring(0, urlParams.length - 1);
        return urlParams
    };
    var moreSidedSdk = new moreSided();
    if (l.isSmallFlow) {
        moreSidedSdk.init()
    }
}(this);