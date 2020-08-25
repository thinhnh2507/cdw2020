$(document).ready(function () {

    var address = $("#address");
    var address_ = $("#address_");

    var name = $("#name");
    var name_ = $("#name_");

    var phone = $("#phone");
    var phone_ = $("#phone_");

    var form_save = $("#form_save");
    var btn_save = $("#btn_save");

    address.on("blur", function () {
        if (address.val() === "") {
            address_.css("display", "");
            address_.css("color", "red");
        } else {
            address_.css("display", "none");
        }
    });
    name.on("blur", function () {
        if (name.val() === "") {
            name_.css("display", "");
            name_.css("color", "red");
        } else {
            name_.css("display", "none");
        }
    });
    phone.on("blur", function () {
        if (phone.val() === "") {
            phone_.css("display", "");
            phone_.css("color", "red");
        } else {
            phone_.css("display", "none");
        }
    });

    var check = function () {
        var c = true;
        if (address.val() === "") {
            c = false;
        } else if (name.val() === "") {
            c = false;
        }  else if (phone.val() === "") {
            c = false;
        }
        return c;
    };

    form_save.on("change", function () {
        if (check()) {
            btn_save.removeAttr("disabled");
            btn_save.on("click", function () {
                form_save.submit();
            });
        } else {
            btn_save.attr("disabled", "disabled");
        }
    });


//-----------------------------------------------------------------------

    var password_old = $("#password_old");
    var password_old_ = $("#password_old_");

    var password_new = $("#password_new");
    var password_new_ = $("#password_new_");

    var password_confirm = $("#password_confirm");
    var password_confirm_ = $("#password_confirm_");

    var form_complete = $("#form_complete");
    var btn_complete = $("#btn_complete");
    var checkAjax = $("#checkAjax");
    password_old.on("blur", function () {

        if (password_old.val() === "") {
            password_old_.css("display", "");
            password_old_.css("color", "red");
        } else {
            password_old_.css("display", "none");
        }
    });

    password_new.on("blur", function () {
        if (password_new.val() === "") {
            password_new_.css("display", "");
            password_new_.css("color", "red");
        } else if (password_new.val() === password_old.val()) {
            password_new_.css("color", "red");
            password_new_.html("Mật khẩu mới phải khác với mật khẩu cũ");
            password_new_.css("display", "");
        } else {
            password_new_.css("display", "none");
        }
    });
    password_confirm.on("blur", function () {
        if (password_confirm.val() === "") {
            password_confirm_.html("Mật khẩu không được bỏ trống");
            password_confirm_.css("color", "red");
            password_confirm_.css("display", "");
        } else if (password_confirm.val() !== password_new.val()) {
            password_confirm_.html("Nhập lại mật khẩu không đúng");
            password_confirm_.css("display", "");
        } else {
            password_confirm_.css("display", "none");
        }
    });

    var check_complete = function () {
        var check = true;
        if (password_old.val() === "") {
            check = false;
        } else if (password_new.val() === "") {
            check = false;
        } else {
            if (password_new.val() === password_old.val()) {
                check = false;
            } else if (password_confirm.val() === "") {
                check = false;
            } else if (password_confirm.val() !== password_new.val()) {
                check = false;
            }
        }
        return check;
    };

    form_complete.on("keyup", function () {
        if (check_complete() === true) {
            btn_complete.removeAttr("disabled");
            btn_complete.on("click", function () {
                $.ajax({
                    type: 'POST',
                    url: "/changepass",
                    data: {
                        oldPassword: password_old.val()
                    },
                    success: function (data) {
                        console.log(data + "---");
                        if (data === "error") {
                            form_complete.submit();
                        } else {
                            btn_complete.attr("disabled", "disabled");
                            checkAjax.css("display", "");
                            password_new_.css("display", "");
                            password_new_.css("display", "");
                            password_confirm_.css("display", "");
                        }
                    },
                    error: function (err) {

                    }
                });

            })
        }

    })

});


