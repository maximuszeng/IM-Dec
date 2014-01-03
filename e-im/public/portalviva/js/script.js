// Create an array of images that you'd like to use
    var images = [
        "/portalviva/img/01.jpg",
        "/portalviva/img/02.jpg",
        "/portalviva/img/03.jpg",
        "/portalviva/img/04.jpg"
    ];
    
    // A little script for preloading all of the images
    // It's not necessary, but generally a good idea
    $(images).each(function(){
        $('<img/>')[0].src = this; 
    });
    
    // The index variable will keep track of which image is currently showing
        var index = 0;
        
        // Call backstretch for the first time,
        // In this case, I'm settings speed of 500ms for a fadeIn effect between images.
        $.backstretch(images[index], {speed: 500});
        
        // Set an interval that increments the index and sets the new image
        // Note: The fadeIn speed set above will be inherited
        setInterval(function() {
            index = (index >= images.length - 1) ? 0 : index + 1;
            $.backstretch(images[index]);
        }, 5000);


        

$(function() {
      
        $( '#jms-slideshow' ).jmslideshow({autoplay:true, fullscreen:true, arrows:false});
        
      });
	
$(document).ready(function(){

	

	$('.overlay-block').transition({ scale: 0.0 });

	
	//Home page work blocks
	$('.home-project-thumb').mouseenter(function(){
		$(this).find('img').transition({ opacity: 0.6 });
		$(this).find('.overlay-block').fadeIn().transition({ scale: 1.0 });
	})
	$('.home-project-thumb').mouseleave(function(){
		$('.home-project-thumb').find('.overlay-block').transition({ scale: 0.0 }).fadeOut();
		$('.home-project-thumb').find('img').fadeIn().transition({ opacity: 1  });
	})
	
	// Blur images on mouse over
	$(".works a").hover( function(){ 
		$(this).children("img").animate({ opacity: 0.75 }, "fast"); 
	}, function(){ 
		$(this).children("img").animate({ opacity: 1.0 }, "slow"); 
	}); 
	
	//works Mouse Effects
	$('.item').mouseenter(function(e) {
		$(this).find('.overlay-block').fadeIn(1000,'swing');
		
	});
	
	$('.item').mouseleave(function(e) {
		$('.item').find('.overlay-block').fadeOut(100);
	});

	
	$('#service-accordion').find('.accordion-heading').click(function(){
		$('#service-accordion').find('.accordion-heading').css('background','#ffffff');
		$('#service-accordion').find('a').css('color','#000000');
		$(this).css('background','#93BAB9');
		$(this).find('a').css('color','#ffffff');
	});


	//--------------------------
	//FILTER MODULE:
	//---------------------------
	
	// Initialize prettyPhoto plugin
	$(".portfolio a[data-gal^='prettyPhoto']").prettyPhoto({
		theme:'light_square', 
		autoplay_slideshow: false, 
		overlay_gallery: false, 
		show_title: false
	});

	// Clone portfolio items 
	var $data = $(".portfolio").clone();
	
	// Attempt to call Quicksand on every click event handler
	$(".filter a").click(function(e){
		
		
		
		$(".filter li").removeClass("current");	
		
		// Get the class attribute value of the clicked link
		var $filterClass = $(this).parent().attr("class");

		if ( $filterClass == "all" ) {
			var $filteredPortfolio = $data.find("li");
		} else {
			var $filteredPortfolio = $data.find("li[data-type~=" + $filterClass + "]");
		}
		
		
		
		// Call quicksand
		$(".portfolio").quicksand( $filteredPortfolio, { 
			duration: 800, 
			easing: 'easeInOutQuad' 
		}, function(){
			
			//HERE WE ARE INVOKING CALLBACK THROUGHT THE SAME FUNCTIONS FOR OVERLAY AND PRETTYPHOTO, 
			//SO EACH TIME WHEN FILTERED EVERYTHING WILL WORK PROPERLY:
			
							// Blur images on mouse over
							$(".works a").hover( function(){ 
								$(this).children("img").animate({ opacity: 0.75 }, "fast"); 
							}, function(){ 
								$(this).children("img").animate({ opacity: 1.0 }, "slow"); 
							}); 
							
							//works Mouse Effects
							$('.item').mouseenter(function(e) {
								$(this).find('.overlay-block').fadeIn(1000,'swing');
								
							});
							
							$('.item').mouseleave(function(e) {
								$('.item').find('.overlay-block').fadeOut(100);
							});
						
						
							
							// Initialize prettyPhoto plugin
							$(".portfolio a[data-gal^='prettyPhoto']").prettyPhoto({
								theme:'light_square', 
								autoplay_slideshow: false, 
								overlay_gallery: false, 
								show_title: false
							});

	
		});

		
		

		$(this).parent().addClass("current");

		// Prevent the browser jump to the link anchor
		e.preventDefault();
	})
});



// Initialize prettyPhoto plugin
	$(".portfolio a[data-gal^='prettyPhoto']").prettyPhoto({
		theme:'light_square', 
		autoplay_slideshow: false, 
		overlay_gallery: false, 
		show_title: false
	});


	$(document).ready(function(){

		$('.element').mouseenter(function(){
			$(this).find('img').stop().animate({opacity:'0.3'});
		});
		$('.element').mouseleave(function(){
			$('.element').find('img').stop().animate({opacity:'1'});
		});

	});


	$(document).ready(function(){
		$('#home-top').waypoint(function(event, direction) {
		   		if (direction === 'down') {
		   			$('#masthead').addClass('nav-pop-up');
				 }
				 else {
		   			$('#masthead').removeClass('nav-pop-up');
				 }
		}, {
   offset: '75%', scrollThrottle: 2000, resizeThrottle: 500 
});


		$('.page').waypoint(function(event, direction) {
				var pageIndex = $(this).attr('id');

		   		if (direction === 'down') {
					$('.scrollernav a').removeClass('active');
		   			$('#'+pageIndex+'-link').addClass('active');
				 }
				 else {
				 }
		}, {
   offset: '75%', scrollThrottle: 2000, resizeThrottle: 500 
});



	$('.page').mouseenter(function(){
		var sectionIndex = $(this).attr('id');
		$('.scrollernav a').removeClass('active');
		$('#'+sectionIndex+'-link').addClass('active');
		$('#'+sectionIndex+'-link-foot').addClass('active');
	})


	});


	$(document).ready(function() {
	    $(".scrollme").scrollerBird({
		speed : 2000,
		easing: 'easeInOutExpo',
		});

		$('.scrollernav a').click(function(){
			$('.scrollernav a').removeClass('active');
			$(this).addClass('active');
		})

	});