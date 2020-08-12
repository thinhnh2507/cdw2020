$(document).ready(function () {
    var username = $("#username");
    var username_ = $("#username_");

    var address = $("#address");
    var address_ = $("#address_");

    var name = $("#name");
    var name_ = $("#name_");

    var password = $("#password");
    var password_ = $("#password_");

    var re_password = $("#re_password");
    var re_password_ = $("#re_password_");

    var phone = $("#phone");
    var phone_ = $("#phone_");


    var btn_reset = $("#reset");
    var btn_submit = $("#submit");
    var register_form = $("#register_form");

    var ajax_me = false;

    username.on("blur", function () {
        if (username.val() === "") {
            username_.css("display", "");
        } else {
            console.log(username.val())
            $.ajax({
                type: 'POST',
                url: "/ajaxRegister",
                data: {
                    username : username.val(),
                },
                success: function (data) {

                    if (data === "success") {
                        username_.css("display", "none");
                        ajax_me = true;
                    } else {
                        username_.html("Tài khoản đã tồn tại");
                        username_.css("color", "red");
                        username_.css("display", "");

                    }
                },
                error: function (err) {

                }
            });
        }
    });
    address.on("blur", function () {
        if (address.val() == "") {
            address_.css("display", "");
            address_.css("color", "red");
        } else {

            address_.css("display", "none");
        }
    });
    name.on("blur", function () {
        if (name.val() == "") {
            name_.css("display", "");
            name_.css("color", "red");
        } else {
            name_.css("display", "none");
        }
    });
    password.on("blur", function () {
        if (password.val() == "") {
            password_.css("display", "");
            password_.css("color", "red");
        } else {
            password_.css("display", "none");
        }
    });
    re_password.on("blur", function () {
        if (re_password.val() == "") {
            re_password_.html("mật khẩu k dc bỏ trống")
            re_password_.css("display", "");
            re_password_.css("color", "red");
        } else {
            if(re_password.val()== password.val()){
                re_password_.css("display", "none");
            } else {
                re_password_.html("phải trùng khớp mật khẩu")
                re_password_.css("display","")
                re_password_.css("color", "red");
            }

        }
    })

    phone.on("blur", function () {
        if (phone.val() == "") {
            phone_.css("display", "");
            phone_.css("color", "red");
        } else {
            phone_.css("display", "none");
        }
    });


    var check = function () {
        var c = true;
        if (username.val() === "") {
            c = false;
        }
        if (address.val() === "") {
            c = false;
        }
        if (name.val() === "") {
            c = false;
        }
        if (password.val() === "") {
            c = false;
        }
        if (re_password.val()===""){
            c = false;
        }
        if(phone.val()===""){
            c = false;
        }
        return c;
    };
    register_form.on("keyup", function () {
        if (check() === true && ajax_me === true) {
            btn_submit.removeAttr("disabled");
            btn_submit.on("click", function () {
                register_form.submit();
            });
        } else {
            btn_submit.attr("disabled", "disabled");
        }

    })


});