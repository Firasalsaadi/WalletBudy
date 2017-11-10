<%@ page language="java"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>WalletBuddy - See where your money goes.</title>
        <meta name="description" content="Great application for recording your spendings.">
        <meta name="keywords" content="WalletBuddy, Personal Finance, Budgeting, Finance, expense tracker">
        <meta name="author" content=" " />
        <meta name="robots" content="index,FOLLOW">

        <!-- For mobile devices -->
        <meta id="Viewport" name="viewport" content="initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">

        <meta name="application-name" content="WalletBuddy"> 

<link href="./resources/index/css" rel="stylesheet"> 
        <!-- Social metas --> 


        
        <!--[if gte IE 9]>
          <style type="text/css">
            .gradient {
               filter: none;
            }
          </style>
        <![endif]-->

        
        <link rel="stylesheet" href="./resources/index/stylesheet.min.css">
        <link rel="stylesheet" href="./resources/index/magnificPopup.css"> 
		<script src="./resources/index/modernizr-2.8.3.min.js.download"></script>
        <script src="./resources/index/detectizr.js.download"></script>
  </head>
 <body>
        
        <!-- ====================    Page Header BEGIN    ==================== -->
    
   

    <div id="content-wrap">    
        
        
        
<header class="l_fullwidth" id="s_pageHeader">
            <nav id="js_pageNav" class="child-nav">
                <ul>
                    <li><a href="http://localhost:8080/walletbuddy/" class="this-active">Home</a></li>
                    <li><a href="#" class="this-hero">Pro Version</a></li>
                    <li><a href="#">Support</a></li>
                    <li><a href="http://localhost:8080/walletbuddy/aboutus">about us</a></li> 
                    <li><a href="http://localhost:8080/walletbuddy/login" class="login">${loginMsg}</a></li>
                </ul>
            </nav>
            <a href="http://localhost:8080/walletbuddy/" class="child-logo js_headerLogo"></a>
            <div class="child-socialWrap">
                <div class="child-item this-fb"><div class="fb-like fb_iframe_widget" data-href="https://www.facebook.com/WalletBuddy" data-layout="button_count" data-action="like" data-size="small" data-show-faces="false" data-share="true" fb-xfbml-state="rendered" fb-iframe-plugin-query="action=like&amp;app_id=505573612824624&amp;container_width=0&amp;href=https%3A%2F%2Fwww.facebook.com%2FWalletBuddy&amp;layout=button_count&amp;locale=en_US&amp;sdk=joey&amp;share=true&amp;show_faces=false&amp;size=small"><span style="vertical-align: bottom; width: 113px; height: 20px;"><iframe name="f143361c13b2524" width="1000px" height="1000px" frameborder="0" allowtransparency="true" allowfullscreen="true" scrolling="no" title="fb:like Facebook Social Plugin" src="./resources/index/like.html" style="border: none; visibility: visible; width: 113px; height: 20px;" class=""></iframe></span></div></div>
                <div class="child-item this-tw"><iframe id="twitter-widget-0" scrolling="no" frameborder="0" allowtransparency="true" class="twitter-share-button twitter-share-button-rendered twitter-tweet-button" title="Twitter Tweet Button" src="./resources/index/tweet_button.c7112f7adf6a24ddcb78d834866e1439.en.html" style="position: static; visibility: visible; width: 60px; height: 20px;"></iframe><script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script></div>
            </div>
            <div class="child-navToggle js-toggleNav" data-target="#s_pageHeader"><span class="child-iconInactive"></span></div>
</header>
        
        <!-- ====================    Page Header END    ==================== -->
        <div id="l_pageContentWrap">
            <div class="l_pageContent">
                <div id="js_page-intro"></div>
                <div class="l_landingWrap">
                    <!-- ====================    Section Landing Intro BEGIN    ==================== -->
                    
                    <section class="l_section" id="s_landingIntro">
                        <div class="l_bgWrap">
                            <div class="child_bg-top js-introBgTop"></div>
                            <div class="child_bg-bot gradient js-introBgBot"></div>
                        </div>
                        <div class="l_inside">
                            <article class="child-textWrap js_transformScaleY js_getTranslateY">
                                <h1 class="child-logo" style="color:white;font-size:72px;font-weight:bold">WalletBuddy</h1>
                                <p class="child-paragraph" style="color:white;font-size:38px;">See where your money goes..</p>
                                <div class="child-buttonWrap">
                                    <a href="http://localhost:8080/walletbuddy/signup" class="child-button this-account">
                                    <span>${signupMsg}</span></a>
                                </div>
                                
                                <div class="getItOnStores">
                                    <p class="child-paragraph" style="color:white;font-size:28px;">Manage money on the go in the app</p>
                                    <a target="_blank" href="https://itunes.apple.com/app/spendee/id635861140"><img src="./resources/index/appstore-btn.svg" alt="WalletBuddy on appstore" style="width: 206px;"></a>
                                    <a target="_blank" href="https://play.google.com/store/apps/details?id=com.cleevio.spendee"><img src="./resources/index/googleplay-btn.svg" alt="WalletBuddy on play store" style="width: 206px;"></a>
                                    
                                </div>
                            </article>
                            <div class="child-phoneWrap js_transformScaleY">
                                <!-- <div class="child-phoneBack"></div> /-->
                                <div class="child-phoneFront"></div>
                            </div>
                        </div>
                    </section>
                    
                    <!-- ====================    Section Landing Intro END    ==================== -->
                    <!-- ====================    Section Landing 1 BEGIN    ==================== -->
                   
                    <section class="l_section" id="s_landingSection1">
                        <div class="l_bgWrap">
                        </div>
                        <div class="l_inside">
                            <div class="child-phoneWrap js_transformScaleY">
                                <div class="child-phoneBg"></div>
                                <div class="child-phoneBack"></div>
                                <div class="child-phoneFront"></div>
                            </div>
                            <article class="child-textWrap js_transformScaleY js_getTranslateY">
                                <header>
                                    <h2>The most intuitive finance app ever</h2>
                                </header>
                                <hr>
                                <p>WalletBuddy App brings you many amazing features. Managing your personal finances has never been easier. <br>Now you can connect your WalletBuddy account with your online banking. Your transactions are downloaded and categorized automatically.</p>
                                <a onclick="playVideo()" style="cursor: pointer;" class="child-button" id="popup-video">Watch our video</a>
                            </article>
                        </div>
                    </section>
                    
                   
                    <!-- ====================    Section Landing 1 END    ==================== -->            
                    <!-- ====================    Section Landing 2 BEGIN    ==================== -->
                    
                    <section class="l_section" id="s_landingSection2">
                        <div class="l_bgWrap">
                        </div>
                        <div class="l_inside">
                            <div class="child-textsWrap">
                                <article class="child-textWrap this-left js_transformScaleY js_section2-text1">
                                    <header>
                                        <h2>Powerful back-end design</h2>
                                        <img src="./resources/index/springcombo.jpg" style="width:480px;margin-top:50px;margin-left:-20px;">
                                    </header> 
                                </article>
                                <article class="child-textWrap this-left js_transformScaleY js_section2-text2">
                                    <header>
                                        
                                    </header>
                                 <br>
                                    <p></p>
                                </article>
                                
                                <article class="child-textWrap this-left js_transformScaleY js_section2-text3">
                                    <header>
                                        <h2>Superb overview</h2>
                                    </header>
                                   
                                    <p>Get a great grasp of your finances with our unique overviews and beautifully designed, easy-to-read graphs.</p>
                                </article>
                            </div>
                            <div class="child-phoneWrap js_section2-phoneWrap">
                                <!--
                                <div class="child-phoneTopWrap js_transformScaleY">
                                    <div class="child-phoneTop"></div>
                                </div>
                                /-->
                                <div class="child-phoneBottomWrap js_transformScaleY">
                                    <div class="child-phoneBottom"></div>
                                </div>
                            </div>
                            <footer class="child-bottomRow js_transformScaleY">
                                <p>Want to see <strong>more features?</strong> Check <a href="#" class="child-button">
								WalletBuddy Pro</a></p>
                            </footer>
                        </div>
                    </section>
                    
                    <!-- ====================    Section Landing 2 END    ==================== -->
                    
                    
                    
                    <!-- ====================    Section Landing 4 BEGIN    ==================== -->
                    
                    <section class="l_section" id="s_landingSection4">
                        <div class="l_bgWrap">
                        </div>
                        <div class="l_inside">
                            <header class="child-header js_transformScaleY">
                                <h2>Technologies Implemented</h2>
                                <hr>
                            </header>
                            <div class="child-group js_transformScaleY">
                                <article class="child-item">
                                    <div class="child-imgWrap"><img src="./resources/index/html.jpg" style="width:140px;"> </div>
                                    <div class="child-textWrap">
                                        <header>
                                            <h3>HTML, CSS3, HTML5</h3>
                                        </header>
                                        <p>Makes solid use of programming and markup languages that are used to create web applications</p>
                                    </div>
                                </article>
                                <article class="child-item">
                                    <div class="child-imgWrap"><img src="./resources/index/bootstrap.png" style="width:180px;"></div>
                                    <div class="child-textWrap">
                                        <header>
                                            <h3></h3>
                                        </header>
                                        <p>Open source toolkit for developing cool and responsive pages with HTML, CSS, and JS</p>
                                    </div>
                                </article>
                                <article class="child-item">
                                    <div class="child-imgWrap"><img src="./resources/index/jquery.png" style="width:200px;"></div>
                                    <div class="child-textWrap">
                                        <header>
                                            <h3></h3>
                                        </header>
                                        <p>Cross-platform JavaScript library designed to simplify the client-side scripting of HTML</p>
                                    </div>
                                </article>
                                
                                
                                <article class="child-item">
                                    <div class="child-imgWrap"><img src="./resources/index/ajax.jpg" style="width:200px;"></div>
                                    <div class="child-textWrap">
                                        <header>
                                            <h3></h3>
                                        </header>
                                        <p>Uses a combination of browser built-in XMLHttpRequest object to request data from a web server and JavaScript / HTML DOM to display or use the data</p>
                                    </div>
                                </article>
                                
                                
                                <article class="child-item">
                                    <div class="child-imgWrap"><img src="./resources/index/javaee.png" style="width:180px;"></div>
                                    <div class="child-textWrap">
                                        <header>
                                            <h3></h3>
                                        </header>
                                        <p>Java Platform, Enterprise Edition - the standard in community-driven enterprise software</p>                                
                                    </div>
                                </article>
                                <article class="child-item">
                                    <div class="child-imgWrap"><img src="./resources/index/mysql.png" style="width:200px;"></div>
                                    <div class="child-textWrap">
                                        <header>
                                            <h3></h3>
                                        </header>
                                        <p>Widely used open-source relational database management system</p>
                                    </div>
                                </article>
                                
                                <article class="child-item">
                                    <div class="child-imgWrap"><img src="./resources/index/spring.png" style="width:260px;"></div>
                                    <div class="child-textWrap">
                                        <header>
                                            <h3></h3>
                                        </header>
                                        <p>Application framework and inversion of control container for the Java platform</p>
                                    </div>
                                </article>
                                
                                <article class="child-item">
                                    <div class="child-imgWrap"><img src="./resources/index/hibernate.jpg" style="width:260px;"></div>
                                    <div class="child-textWrap">
                                        <header>
                                            <h3></h3>
                                        </header>
                                        <p>Object-Relational Mapping tool for the Java which provides a framework for mapping an object-oriented domain model to a relational database</p>
                                    </div>
                                </article>
                            </div>
                            <footer class="child-bottomRow js_transformScaleY">
                                <p>Want to see <strong>more features?</strong> Check <a href="#" class="child-button">WalletBuddy pro</a></p>
                            </footer>
                        </div>
                    </section>
                    
                    <!-- ====================    Section Landing 4 END    ==================== -->
                    <!-- ====================    Section Landing 5 BEGIN    ==================== -->
                    
                    <section class="l_section" id="s_landingSection5">
                        <div class="l_bgWrap">
                        </div>
                        <div class="l_inside">
                            <header class="child-header js_transformScaleY">
                                <h2>What people say</h2>
                                <hr>
                            </header>
                            <div class="child-wrap">
                                <div class="child-columnLeftWrap js_transformScaleY">
                                    <div class="child-columnLeft">
                                        <div class="child-quoteGroup js_section5-quoteGroup">
                                            <blockquote class="child-quote  this-active">
                                                <h2><a href="http://www.nytimes.com/2014/01/04/your-money/household-budgeting/review-apps-to-track-income-and-expenses.html?_r=0">Make a Resolution to Budget?</a></h2>
                                                <p>WalletBuddy, which is easy to use and pleasing to look at, and can back up data to iCloud and export it if you wish.</p>
                                                <footer>
                                                    <p>Read more in <a target="_blank" class="js_section5-quoteLink" href="http://www.nytimes.com/2014/01/04/your-money/household-budgeting/review-apps-to-track-income-and-expenses.html?_r=0">The New York Times</a></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote">
                                                <h2><a href="http://www.idownloadblog.com/2013/07/24/spendee-ios-review/">WalletBuddy helps you keep track of finances with little effort</a></h2>
                                                <p>This app is incredibly simple to use. It is the perfect personal finance tracker for people who hate dealing with finances. </p>
                                                <footer>
                                                    <p>Read more in <a target="_blank" class="js_section5-quoteLink" href="http://www.idownloadblog.com/2013/07/24/spendee-ios-review/">iDownloadBlog</a></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote">
                                                <h2><a href="http://lifehacker.com/spendee-tracks-your-expenses-with-a-gorgeous-frictionl-849929516">WalletBuddy Tracks Your Expenses with a Gorgeous, Frictionless Interface</a></h2>
                                                <p>The more you use WalletBuddy, the more valuable it gets, rewarding your diligence with attractive charts that show you where your money is going, and how your costs are matching up with your income.</p>
                                                <footer>
                                                    <p>Read more in <a target="_blank" class="js_section5-quoteLink" href="http://lifehacker.com/spendee-tracks-your-expenses-with-a-gorgeous-frictionl-849929516">lifehacker</a></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote">
                                                <h2><a href="http://www.imore.com/simplify-track-and-analyze-your-personal-finances-spendee-iphone">WalletBuddy for iPhone not only helps you track your finances, but analyze them too!</a></h2>
                                                <p>WalletBuddy actually gives you useful data that can help you change spending habits. It's great option for not only tracking but for analysis as well</p>
                                                <footer>
                                                    <p>Read more in <a target="_blank" class="js_section5-quoteLink" href="http://www.imore.com/simplify-track-and-analyze-your-personal-finances-spendee-iphone">iMore</a></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-active">
                                                <h2><a href="http://www.cultofmac.com/235844/spendee-is-the-iphone-budgeting-app-that-youll-actually-want-to-use/">WalletBuddy Is The iPhone Budgeting App That You’ll Actually Want To Use</a></h2>
                                                <p>So far I like it a lot. It’s simple yet powerful, has everything I need, and doesn’t require that I give it a log in to my bank account.</p>
                                                <footer>
                                                    <p>Read more in <a target="_blank" class="js_section5-quoteLink" href="http://www.cultofmac.com/235844/spendee-is-the-iphone-budgeting-app-that-youll-actually-want-to-use/">Cult of Mac</a></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote">
                                                <h2><a href="http://beautifulpixels.com/iphone/spendee-is-a-remarkably-good-expense-tracker-for-your-iphone/">WalletBuddy is a Remarkably Good Expense Tracker for your iPhone</a></h2>
                                                <p>WalletBuddy’s UI is quite possibly one of the most delicious set of pixels to make its way onto my iPhone ever since Apple demoed iOS 7 at WWDC.</p>
                                                <footer>
                                                    <p>Read more in <a target="_blank" class="js_section5-quoteLink" href="http://beautifulpixels.com/iphone/spendee-is-a-remarkably-good-expense-tracker-for-your-iphone/">Beautiful Pixels</a></p>
                                                </footer>
                                            </blockquote>
                                        </div>
                                        <div class="child-logoGroup js_section5-logoGroup">
                                            <div class="child-row">
                                                <div class="child-cell"><a class="js_section5-quoteToggle" data-target="1" target="_blank" href="http://www.idownloadblog.com/2013/07/24/spendee-ios-review/"><img src="./resources/index/landing5-logo1.png" alt=""></a></div>
                                                <div class="child-cell"><a class="js_section5-quoteToggle" data-target="2" target="_blank" href="http://lifehacker.com/spendee-tracks-your-expenses-with-a-gorgeous-frictionl-849929516"><img src="./resources/index/landing5-logo2.png" alt=""></a></div>
                                                <div class="child-cell"><a class="js_section5-quoteToggle" data-target="3" target="_blank" href="http://www.imore.com/simplify-track-and-analyze-your-personal-finances-spendee-iphone"><img src="./resources/index/landing5-logo3.png" alt=""></a></div>
                                            </div>
                                            <div class="child-row">
                                                <div class="child-cell"><a class="js_section5-quoteToggle this-active" data-target="4" target="_blank" href="http://www.cultofmac.com/235844/spendee-is-the-iphone-budgeting-app-that-youll-actually-want-to-use/"><img src="./resources/index/landing5-logo4.png" alt=""></a></div>
                                                <div class="child-cell"><a class="js_section5-quoteToggle" data-target="5" target="_blank" href="http://www.nytimes.com/2014/01/04/your-money/household-budgeting/review-apps-to-track-income-and-expenses.html?_r=0"><img src="./resources/index/landing5-logo5.png" alt=""></a></div>
                                                <div class="child-cell">
												<a class="js_section5-quoteToggle" data-target="6" target="_blank" 
												href="http://beautifulpixels.com/iphone/spendee-is-a-remarkably-good-expense-tracker-for-your-iphone/">
												<img src="./resources/index/landing5-logo6.png" alt=""></a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="child-columnRightWrap js_transformScaleY">
                                    <div class="child-columnRight js_section5-quoteGroup2">
                                        <div class="js_section5-quoteWrap" style="position: relative;">
                                             
                                        <blockquote class="child-quote this-googleRed">
                                                <p>Best app to control the daily expenses. 5/5</p>
                                                <footer>
                                                    <p>by <strong>Alekz21</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-appleRed">
                                                <p>Excited for @WalletBuddy 2.0<br>definitely my fave finance app on IOS with some great UX</p>
                                                <footer>
                                                    <p>by <strong>WHMII</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-googleGreen">
                                                <p>In adv of going self-employed I'm getting my finances in order & have discovered @WalletBuddy . Brill for personal budgeting. Recommended!</p>
                                                <footer>
                                                    <p>by <strong>ladystephina</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-appleGreen">
                                                <p>I'm terrible with money, but I sure do love @WalletBuddy.</p>
                                                <footer>
                                                    <p>by <strong>SallyPoulsen</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-appleBlue">
                                                <p>I just came across this app. I've spent only a few minutes on it and I already love it</p>
                                                <footer>
                                                    <p>by <strong>kessir_</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-appleGreen">
                                                <p>@SystemsThatRock a cool little app! WalletBuddy.com thanks for coming up from Belgium! You are amazing!! xx</p>
                                                <footer>
                                                    <p>by <strong>LisDingjan</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-googleYellow">
                                                <p>Really nice iOS app for expense / income tracking WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>igorkulman</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-appleYellow">
                                                <p>@WalletBuddy is such a neat app to keep track of your expenses/income. Highly recommended! </p>
                                                <footer>
                                                    <p>by <strong>jordanjtan</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-appleYellow">
                                                <p>WalletBuddy looks really cool! #productivity WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>okidoci</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-googleRed">
                                                <p>You guys are doing a terrific job with the app. Love it!</p>
                                                <footer>
                                                    <p>by <strong>francistan</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-appleGreen">
                                                <p>wow, I just found out that Apple uses @WalletBuddy as a promo in Apple Store for Business store.apple.com/us/iphone/busi… great job @WalletBuddy !</p>
                                                <footer>
                                                    <p>by <strong>kubabrecka</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-googleRed">
                                                <p>I started to use @WalletBuddy as my personal financial management app. So far so good. WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>tankista</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-googleGreen">
                                                <p>Amazing #UX in the iPhone app @WalletBuddy #Productivity #ui  WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>leandrobutteri</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-googleBlue">
                                                <p>Great looking iOS app for tracking expenses, nice website too WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>MetroMcCann</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-appleRed">
                                                <p>@WalletBuddy is gorgeously designed and I can't wait to start using it! #Productivity WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>emmeffess</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-googleYellow">
                                                <p>This looks fresh, and because I know you've been looking - WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>JackRMcDermott</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-googleBlue">
                                                <p>Very cool app spendee and nice site tells you all about it visually. Might stop my money disappearing every month...WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>handyandydesign</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-appleBlue">
                                                <p>Icon, app, landing page, site - beautiful design!  WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>pausedsn</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-googleYellow">
                                                <p>Always on the lookout for a good finance app. @WalletBuddy seems really nice. WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>jasonrbarry</strong></p>
                                                </footer>
                                            </blockquote>
                                            <blockquote class="child-quote this-appleGreen">
                                                <p>Finally a new app I'm excited about: WalletBuddy.com</p>
                                                <footer>
                                                    <p>by <strong>mattvagni</strong></p>
                                                </footer>
                                            </blockquote>
											</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    
                    <!-- ====================    Section Landing 5 END    ==================== -->
                    <!-- ====================    Section Landing 6 BEGIN    ==================== -->
                    
                    <section class="l_section" id="s_landingSection6">
                        <div class="l_bgWrap">
                        </div>
                        <div class="l_inside">
                            <header class="child-header js_transformScaleY">
                                <h2 style="color: rgb(64,180,229);font-weight:bold;font-size:90px;">Thank You IT Talents Team!</h1>
                                <hr>
                            </header>
                            <div class="child-buttonWrap js_transformScaleY">
                                <a target="_blank" href="https://itunes.apple.com/app/spendee/id635861140" class="child-button this-appstore">
								<span>Free download on<strong>App Store</strong></span></a>
                                <a target="_blank" href="https://play.google.com/store/apps/details?id=com.cleevio.spendee" class="child-button this-gplay">
								<span>Free download on<strong>Google Play</strong></span></a>
                                <a href="https://app.spendee.com/auth/login" class="child-button this-webapp">
								<span>Login for free to<strong>WEB APP</strong></span></a>
                            </div>
                            <div class="child-phoneWrap js_transformScaleY">
                                <div class="child-bgIcons"></div>
                                <div class="child-phoneBackWrap">
                                    <div class="child-phoneBack"></div>
                                </div>
                                <div class="child-phoneFrontWrap">
                                    <div class="child-phoneFront"></div>
                                </div>
                            </div>
                        </div>
                    </section>
                    
                    <!-- ====================    Section Landing 6 END    ==================== -->
               </div>
            </div>
        </div>

        <div id="js_loading" class="l_pageLoading">
            <div class="child-loading"></div>
        </div>

        <!-- ====================   Page Footer BEGIN      ==================== -->
        
<div class="clearfix"></div>
        <footer class="l_fullwidth this-intro" id="s_pageFooter">
            <div class="child-arrowDown js_intro-arrowDown"></div>
            <!--
            <div class="child-buttonWrap">
                <div class="child-buttonInner">
                    <a target="_blank" href="https://itunes.apple.com/us/app/spendee/id635861140" class="child-button this-appstore"></a>
                    <a target="_blank" href="https://play.google.com/store/apps/details?id=com.cleevio.spendee" class="child-button this-gplay"></a>
                    <span class="child-buttonText">DOWNLOAD<br>SPENDEE NOW</span>
                </div>
            </div>
            /-->
            <div class="child-wrap">
                <div class="child-textWrap">
                    <p>iPhone is a trademark of Apple Inc. <br>App Store is a service mark of Apple inc.</p>
                </div>
                <div class="child-socialsWrap">
                    <a target="_blank" href="https://www.facebook.com/WalletBuddy" class="child-button this-fb"></a>
                    <a target="_blank" href="https://twitter.com/WalletBuddy" class="child-button this-tw"></a>
                    <a target="_blank" href="https://plus.google.com/explore/WalletBuddy" class="child-button this-gp"></a>
                </div>
            </div>
</footer>
        
    </div>    
        
        <!-- ====================   Page Footer END ==================== -->
        

        <!--
        <section class="l_section">
            <div class="l_bgWrap">
            </div>
            <div class="l_inside">
            </div>
        </section>
        -->
        
    

        <script src="./resources/index/jquery.min.js.download"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.1.min.js"><\/script>')</script>
        <script src="./resources/index/plugins.js.download"></script>
        <script src="./resources/index/main.js.download"></script>
        <script src="./resources/index/magnificPopup.min.js.download"></script>
        <script src="./resources/index/jquery.foggy.min.js.download"></script>
        <script src="./resources/index/iframe_api"></script>
   


</body></html>