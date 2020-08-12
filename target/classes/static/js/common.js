var Slide = {
    homeFeature: function () {
        var homeFeature = new Swiper('.__home_feature_slide .swiper-container', {
            speed: 600,
            navigation: {
                nextEl: '.__home_feature_slide .slide-next',
                prevEl: '.__home_feature_slide .slide-prev',
                hideOnClick: true
            },
            pagination: {
                el: '.__home_feature_slide .slide-pagination',
                type: 'bullets',
                renderBullet: function (index, className) {
                    return '<span class="' + className + '"><i class="fas fa-shoe-prints"></i></span>';
                },
                clickable:true
            }
        });
    },
    promotionSlide: function () {
        var promotion_slide = new Swiper('.promotion-slide .gallery-thumbs', {
            spaceBetween: 0,
            slidesPerView: 3,
            freeMode: true,
            watchSlidesVisibility: true,
            watchSlidesProgress: true,
        });
        var promotion_thumb = new Swiper('.promotion-slide .gallery-top', {
            spaceBetween: 0,
            navigation: {
                nextEl: '.promotion-slide .slide-next',
                prevEl: '.promotion-slide .slide-prev',
            },
            thumbs: {
                swiper: promotion_slide
            }
        });
    },
    productDetail: function () {
        var productDetailThumbs = new Swiper('.product-left-zone .product-gallery-thumbs', {
            spaceBetween: 10,
            slidesPerView: 4,
            direction: 'vertical',
            loopedSlides: 4, //looped slides should be the same
            watchSlidesVisibility: true,
            watchSlidesProgress: true,
            // navigation: {
            //     nextEl: '.product-left-zone .swiper-button-next',
            //     prevEl: '.product-left-zone .swiper-button-prev',
            // },
        });
        var productDetailTop = new Swiper('.product-left-zone .product-gallery-top', {
            spaceBetween: 10,
            direction: 'vertical',
            loopedSlides: 4, //looped slides should be the same
            thumbs: {
                swiper: productDetailThumbs,
            },
        });
    }
};

var Zoom = {
    productZoom: function () {
        var options = {
            width: 450,
            height:400,
            zoomWidth: 500,
            offset: {vertical: 0, horizontal: 10},
            zoomContainer: document.getElementById('zoom-preview'),
        };
        new ImageZoom(document.getElementById("zoom_01"), options);
    }
};

var helper = {
    initNiceSelect: function () {
        $('select').niceSelect();
    },
    initNiceScroll: function () {
        $("p.product-description").niceScroll();
    },
    showComment: function () {
        $(document).on('click', '.btn-reply', function(eve){
            eve.preventDefault();
            $(this).parent().parent().siblings('.comment-footer').slideToggle();
            eve.stopImmediatePropagation();
        });
    }
};


$(document).ready(function () {
    Slide.homeFeature();
    Slide.promotionSlide();
    Slide.productDetail();


    Zoom.productZoom();

    helper.initNiceSelect();
    helper.showComment();
});