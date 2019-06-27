package imposibl3qu1z_fla
{
   import flash.display.MovieClip;
   import flash.display.SimpleButton;
   import flash.events.Event;
   import flash.events.MouseEvent;
   import flash.events.TimerEvent;
   import flash.geom.Rectangle;
   import flash.media.Sound;
   import flash.text.TextField;
   import flash.ui.Mouse;
   import flash.utils.Timer;
   
   public dynamic class MainTimeline extends MovieClip
   {
       
      
      public var restartbutton:SimpleButton;
      
      public var paddle1:MovieClip;
      
      public var paddle2:MovieClip;
      
      public var wine:MovieClip;
      
      public var paddle4:MovieClip;
      
      public var bgmusic:Sound;
      
      public var myText:TextField;
      
      public var lives:Number;
      
      public var paddle3:MovieClip;
      
      public var startbutton:SimpleButton;
      
      public var tball2:MovieClip;
      
      public var tball3:MovieClip;
      
      public var loss:Number;
      
      public var wrong1:SimpleButton;
      
      public var wrong2:SimpleButton;
      
      public var wrong3:SimpleButton;
      
      public var wrong4:SimpleButton;
      
      public var targetObject:MovieClip;
      
      public var countdown:Number;
      
      public var scoreText1:TextField;
      
      public var scoreText2:TextField;
      
      public var startX:Number;
      
      public var startY:Number;
      
      public var lostlife:Number;
      
      public var countdown2:Number;
      
      public var currentObject:MovieClip;
      
      public var xspeed2:Number;
      
      public var xspeed3:Number;
      
      public var track:MovieClip;
      
      public var myText2:TextField;
      
      public var myTimer4;
      
      public var myTimer5;
      
      public var myTimer2;
      
      public var myTimer3;
      
      public var stop1:MovieClip;
      
      public var stop2:MovieClip;
      
      public var stop3:MovieClip;
      
      public var stop4:MovieClip;
      
      public var stop5:MovieClip;
      
      public var stop6:MovieClip;
      
      public var stop7:MovieClip;
      
      public var stop8:MovieClip;
      
      public var stop9:MovieClip;
      
      public var timeout:Number;
      
      public var tball:MovieClip;
      
      public var tballcount:Number;
      
      public var yspeed:Number;
      
      public var skipp1:SimpleButton;
      
      public var started:Number;
      
      public var wrongsound:Sound;
      
      public var yspeed2:Number;
      
      public var yspeed3:Number;
      
      public var loss2:Number;
      
      public var num;
      
      public var dx;
      
      public var dy;
      
      public var stop10:MovieClip;
      
      public var dist;
      
      public var heart1:MovieClip;
      
      public var heart2:MovieClip;
      
      public var heart3:MovieClip;
      
      public var winsound:Sound;
      
      public var offbut:Number;
      
      public var xspeed:Number;
      
      public var skipp:SimpleButton;
      
      public var win:SimpleButton;
      
      public var score1:Number;
      
      public var score2:Number;
      
      public var myTimer;
      
      public var win11:SimpleButton;
      
      public var ball:MovieClip;
      
      public function MainTimeline()
      {
         super();
         addFrameScript(0,this.frame1,1,this.frame2,2,this.frame3,3,this.frame4,4,this.frame5,5,this.frame6,6,this.frame7,7,this.frame8,8,this.frame9,9,this.frame10,10,this.frame11,11,this.frame12,12,this.frame13,13,this.frame14,14,this.frame15,15,this.frame16,16,this.frame17,17,this.frame18,18,this.frame19,19,this.frame20,20,this.frame21,21,this.frame22,22,this.frame23,23,this.frame24);
      }
      
      public function restart2(param1:MouseEvent) : void
      {
         this.restartbutton.removeEventListener(MouseEvent.CLICK,this.restart2);
         gotoAndStop(1);
      }
      
      public function cleanup2() : *
      {
         this.tball.removeEventListener(Event.ENTER_FRAME,this.movetball);
         this.paddle4.removeEventListener(Event.ENTER_FRAME,this.computerPaddle4);
         this.paddle3.removeEventListener(Event.ENTER_FRAME,this.computerPaddle3);
         this.paddle2.removeEventListener(Event.ENTER_FRAME,this.computerPaddle);
         this.paddle1.removeEventListener(Event.ENTER_FRAME,this.playerPaddle);
         this.tball3.removeEventListener(Event.ENTER_FRAME,this.movetball3);
         this.tball2.removeEventListener(Event.ENTER_FRAME,this.movetball2);
         this.tball.removeEventListener(Event.ENTER_FRAME,this.movetball);
      }
      
      public function cleanup3(param1:Event) : void
      {
         this.tball.removeEventListener(Event.ENTER_FRAME,this.movetball);
         this.paddle4.removeEventListener(Event.ENTER_FRAME,this.computerPaddle4);
         this.paddle3.removeEventListener(Event.ENTER_FRAME,this.computerPaddle3);
         this.paddle2.removeEventListener(Event.ENTER_FRAME,this.computerPaddle);
         this.paddle1.removeEventListener(Event.ENTER_FRAME,this.playerPaddle);
         this.tball3.removeEventListener(Event.ENTER_FRAME,this.movetball3);
         this.tball2.removeEventListener(Event.ENTER_FRAME,this.movetball2);
         this.tball.removeEventListener(Event.ENTER_FRAME,this.movetball);
         this.skipp.removeEventListener(MouseEvent.CLICK,this.cleanup3);
         nextFrame();
      }
      
      public function starthold(param1:MouseEvent) : void
      {
         var _loc2_:* = new Timer(1000,3);
         _loc2_.addEventListener(TimerEvent.TIMER_COMPLETE,this.reset3);
         _loc2_.start();
         this.started = 1;
         this.offbut = 0;
      }
      
      public function restart(param1:MouseEvent) : void
      {
         this.restartbutton.removeEventListener(MouseEvent.CLICK,this.restart);
         gotoAndStop(1);
      }
      
      public function action(param1:TimerEvent) : void
      {
         this.myText.text = String(this.countdown);
      }
      
      public function movetball2(param1:Event) : void
      {
         this.tball2.x = this.tball2.x + this.xspeed2;
         this.tball2.y = this.tball2.y + this.yspeed2;
         if(this.tball2.x > 1280)
         {
            this.tball.x = 300;
            this.tball.y = 200;
            this.xspeed = 6;
            this.yspeed = 6;
            this.tball2.x = 300;
            this.tball2.y = -200;
            this.xspeed2 = 0;
            this.yspeed2 = 0;
            this.tball3.x = 300;
            this.tball3.y = -200;
            this.xspeed3 = 0;
            this.yspeed3 = 0;
            this.score2++;
            this.scoreText2.text = String(this.score2);
            this.tballcount = 0;
         }
         if(this.tball2.x < 0)
         {
            this.tball.x = 300;
            this.tball.y = 200;
            this.xspeed = 6;
            this.yspeed = 6;
            this.tball2.x = 300;
            this.tball2.y = -200;
            this.xspeed2 = 0;
            this.yspeed2 = 0;
            this.tball3.x = 300;
            this.tball3.y = -200;
            this.xspeed3 = 0;
            this.yspeed3 = 0;
            this.score1++;
            this.scoreText1.text = String(this.score1);
            this.tballcount = 0;
         }
         if(this.tball2.y > 720 || this.tball2.y < 0)
         {
            this.yspeed2 = this.yspeed2 * -1;
         }
         if(this.tball2.hitTestObject(this.paddle1) && this.xspeed2 > 0)
         {
            this.xspeed2 = this.xspeed2 * -1.03;
            this.tballcount++;
         }
         if(this.tball2.hitTestObject(this.paddle2) && this.xspeed2 < 0)
         {
            this.xspeed2 = this.xspeed2 * -1.03;
         }
         if(this.tball2.hitTestObject(this.paddle3) && this.xspeed2 < 0)
         {
            this.xspeed2 = this.xspeed2 * -1.03;
         }
         if(this.tballcount == 3)
         {
            this.tball2.x = 300;
            this.tball2.y = 200;
            this.xspeed2 = 3;
            this.yspeed2 = 3;
            this.paddle3.x = 10;
            this.paddle3.y = 360;
         }
         if(this.tballcount == 5)
         {
            this.tball3.x = 300;
            this.tball3.y = 200;
            this.xspeed3 = 3;
            this.yspeed3 = 3;
            this.paddle4.x = 30;
            this.paddle4.y = 360;
         }
      }
      
      public function movetball(param1:Event) : void
      {
         this.tball.x = this.tball.x + this.xspeed;
         this.tball.y = this.tball.y + this.yspeed;
         if(this.tball.x > 1280)
         {
            this.tball.x = 300;
            this.tball.y = 200;
            this.xspeed = 6;
            this.yspeed = 6;
            this.tball2.x = 300;
            this.tball2.y = -200;
            this.xspeed2 = 0;
            this.yspeed2 = 0;
            this.tball3.x = 300;
            this.tball3.y = -200;
            this.xspeed3 = 0;
            this.yspeed3 = 0;
            this.score2++;
            this.scoreText2.text = String(this.score2);
            this.tballcount = 0;
         }
         if(this.tball.x < 0)
         {
            this.tball.x = 300;
            this.tball2.x = 300;
            this.tball2.y = -200;
            this.xspeed2 = 0;
            this.yspeed2 = 0;
            this.tball3.x = 300;
            this.tball3.y = -200;
            this.xspeed3 = 0;
            this.yspeed3 = 0;
            this.score1++;
            this.xspeed = 6;
            this.yspeed = 6;
            this.scoreText1.text = String(this.score1);
            this.tballcount = 0;
         }
         if(this.tball.y > 720 || this.tball.y < 0)
         {
            this.yspeed = this.yspeed * -1.01;
         }
         if(this.tball.hitTestObject(this.paddle1) && this.xspeed > 0)
         {
            this.xspeed = this.xspeed * -1.01;
            this.tballcount++;
         }
         if(this.tball.hitTestObject(this.paddle2) && this.xspeed < 0)
         {
            this.xspeed = this.xspeed * -1.01;
            this.tballcount++;
         }
      }
      
      function frame11() : *
      {
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      public function reset(param1:TimerEvent) : *
      {
         this.countdown--;
         this.myTimer.start();
      }
      
      function frame14() : *
      {
         this.myTimer4 = new Timer(500,5);
         this.myTimer4.addEventListener(TimerEvent.TIMER_COMPLETE,this.reset5);
         this.myTimer4.start();
      }
      
      function frame18() : *
      {
         if(this.lives == 2)
         {
            this.heart1.visible = false;
         }
         if(this.lives == 1)
         {
            this.heart1.visible = false;
            this.heart2.visible = false;
         }
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.win.alpha = 0;
      }
      
      function frame12() : *
      {
         this.win.addEventListener(MouseEvent.MOUSE_DOWN,this.starthold);
         this.win.addEventListener(MouseEvent.MOUSE_OUT,this.offbutton);
         this.win.addEventListener(MouseEvent.MOUSE_UP,this.offbutton);
         this.loss2 = 0;
         this.offbut = 0;
         this.started = 7;
      }
      
      public function movetball3(param1:Event) : void
      {
         this.tball3.x = this.tball3.x + this.xspeed3;
         this.tball3.y = this.tball3.y + this.yspeed3;
         if(this.tball3.x > 1280)
         {
            this.tball.x = 300;
            this.tball.y = 200;
            this.xspeed = 6;
            this.yspeed = 6;
            this.tball2.x = 300;
            this.tball2.y = -200;
            this.xspeed2 = 0;
            this.yspeed2 = 0;
            this.tball3.x = 300;
            this.tball3.y = -200;
            this.xspeed3 = 0;
            this.yspeed3 = 0;
            this.score2++;
            this.scoreText2.text = String(this.score2);
            this.tballcount = 0;
         }
         if(this.tball3.x < 0)
         {
            this.tball.x = 300;
            this.tball.y = 200;
            this.xspeed = 6;
            this.yspeed = 6;
            this.tball2.x = 300;
            this.tball2.y = -200;
            this.xspeed2 = 0;
            this.yspeed2 = 0;
            this.tball3.x = 300;
            this.tball3.y = -200;
            this.xspeed3 = 0;
            this.yspeed3 = 0;
            this.score1++;
            this.scoreText1.text = String(this.score1);
            this.tballcount = 0;
         }
         if(this.tball3.y > 720 || this.tball3.y < 0)
         {
            this.yspeed3 = this.yspeed3 * -1;
         }
         if(this.tball3.hitTestObject(this.paddle1) && this.xspeed3 > 0)
         {
            this.xspeed3 = this.xspeed3 * -1.15;
            this.tballcount++;
         }
         if(this.tball3.hitTestObject(this.paddle2) && this.xspeed3 < 0)
         {
            this.xspeed3 = this.xspeed3 * -1.15;
         }
         if(this.tball3.hitTestObject(this.paddle4) && this.xspeed3 < 0)
         {
            this.xspeed3 = this.xspeed3 * -1.15;
         }
         if(this.score1 == 1)
         {
            this.cleanup2();
            this.winsound.play();
            nextFrame();
         }
         if(this.score2 == 1)
         {
            if(this.lives == 1)
            {
               this.cleanup2();
            }
            if(this.loss == 0)
            {
               this.loss = 1;
               this.wrongfun();
            }
         }
         if(this.score2 == 2)
         {
            if(this.loss == 1)
            {
               this.loss = 2;
               if(this.lives == 1)
               {
                  this.cleanup2();
               }
               this.wrongfun();
            }
         }
         if(this.score2 == 3)
         {
            if(this.lives == 1)
            {
               this.cleanup2();
            }
            if(this.loss == 2)
            {
               this.loss = 3;
               this.wrongfun();
            }
         }
      }
      
      public function offbutton(param1:Event) : void
      {
         this.offbut = 1;
         if(this.started == 1)
         {
            this.myTimer2.stop();
         }
         if(this.lives == 0)
         {
            this.win.removeEventListener(MouseEvent.MOUSE_DOWN,this.starthold);
            this.win.removeEventListener(MouseEvent.MOUSE_OUT,this.offbutton);
            this.win.removeEventListener(MouseEvent.MOUSE_UP,this.offbutton);
            this.myTimer2.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset);
         }
         this.wrongfun();
      }
      
      public function computerPaddle(param1:Event) : void
      {
         if(param1.target.y > this.tball.y)
         {
            param1.target.y = param1.target.y - 7.5;
         }
         if(param1.target.y < this.tball.y)
         {
            param1.target.y = param1.target.y + 7.5;
         }
      }
      
      function frame4() : *
      {
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong2.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong3.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong4.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      function frame7() : *
      {
         this.startX = this.ball.x;
         this.startY = this.ball.y;
         this.dx = this.ball.x - mouseX;
         this.dy = this.ball.y - mouseY;
         this.dist = Math.sqrt(this.dx * this.dx + this.dy * this.dy);
         this.lostlife = 0;
         this.myTimer = new Timer(1000,1);
         this.countdown = 35;
         stage.addEventListener(MouseEvent.MOUSE_MOVE,this.moveBall);
         this.myTimer.addEventListener(TimerEvent.TIMER,this.action);
         this.myTimer.addEventListener(TimerEvent.TIMER_COMPLETE,this.reset);
         this.skipp1.addEventListener(MouseEvent.CLICK,this.skipnclean);
      }
      
      function frame6() : *
      {
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong2.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong3.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      function frame9() : *
      {
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
      }
      
      public function computerPaddle4(param1:Event) : void
      {
         if(param1.target.y > this.tball3.y)
         {
            param1.target.y = param1.target.y - 2.65;
         }
         if(param1.target.y < this.tball3.y)
         {
            param1.target.y = param1.target.y + 2.65;
         }
      }
      
      public function moveBall(param1:MouseEvent) : void
      {
         this.dx = this.ball.x - mouseX;
         this.dy = this.ball.y - mouseY;
         this.dist = Math.sqrt(this.dx * this.dx + this.dy * this.dy);
         if(!this.track.hitTestPoint(mouseX,mouseY,true))
         {
            if(this.dist < 33)
            {
               this.ball.x = mouseX;
               this.ball.y = mouseY;
               Mouse.hide();
               this.lostlife = 0;
               this.myTimer.start();
            }
         }
         else
         {
            this.ball.x = this.startX;
            this.ball.y = this.startY;
            Mouse.show();
            if(this.lostlife == 0)
            {
               if(this.lives == 1)
               {
                  stage.removeEventListener(MouseEvent.MOUSE_MOVE,this.moveBall);
                  this.myTimer.removeEventListener(TimerEvent.TIMER,this.action);
                  this.myTimer.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset);
               }
               this.wrongfun();
               this.lostlife = 1;
               return;
            }
         }
         if(this.ball.hitTestObject(this.targetObject))
         {
            Mouse.show();
            stage.removeEventListener(MouseEvent.MOUSE_MOVE,this.moveBall);
            this.myTimer.removeEventListener(TimerEvent.TIMER,this.action);
            this.myTimer.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset);
            this.winsound.play();
            nextFrame();
         }
         if(this.countdown <= 0)
         {
            if(this.lives == 1)
            {
               stage.removeEventListener(MouseEvent.MOUSE_MOVE,this.moveBall);
               this.myTimer.removeEventListener(TimerEvent.TIMER,this.action);
               this.myTimer.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset);
            }
            this.wrongfun();
            Mouse.show();
            this.countdown = 35;
            return;
         }
      }
      
      function frame8() : *
      {
         stop();
         this.xspeed = 8;
         this.yspeed = 8;
         this.xspeed2 = 0;
         this.yspeed2 = 0;
         this.xspeed3 = 0;
         this.yspeed3 = 0;
         this.score1 = 0;
         this.score2 = 0;
         this.tballcount = 0;
         this.loss = 0;
         this.tball.addEventListener(Event.ENTER_FRAME,this.movetball);
         this.tball2.addEventListener(Event.ENTER_FRAME,this.movetball2);
         this.tball3.addEventListener(Event.ENTER_FRAME,this.movetball3);
         this.paddle1.addEventListener(Event.ENTER_FRAME,this.playerPaddle);
         this.paddle2.addEventListener(Event.ENTER_FRAME,this.computerPaddle);
         this.paddle3.addEventListener(Event.ENTER_FRAME,this.computerPaddle3);
         this.paddle4.addEventListener(Event.ENTER_FRAME,this.computerPaddle4);
         this.skipp.addEventListener(MouseEvent.CLICK,this.cleanup3);
      }
      
      public function intime(param1:Event) : void
      {
         this.myTimer5.stop();
         this.win.removeEventListener(MouseEvent.CLICK,this.intime);
         this.myTimer5.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset6);
         nextFrame();
      }
      
      function frame16() : *
      {
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      public function stopADrag(param1:MouseEvent) : void
      {
         if(this.currentObject != null)
         {
            this.currentObject.stopDrag();
         }
      }
      
      function frame19() : *
      {
         this.win11.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong2.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong3.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      function frame22() : *
      {
         if(this.lives == 2)
         {
            this.heart1.visible = false;
         }
         if(this.lives == 1)
         {
            this.heart1.visible = false;
            this.heart2.visible = false;
         }
         this.win.addEventListener(MouseEvent.CLICK,this.wingame);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong2.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong3.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      public function computerPaddle3(param1:Event) : void
      {
         if(param1.target.y > this.tball2.y)
         {
            param1.target.y = param1.target.y - 2.33;
         }
         if(param1.target.y < this.tball2.y)
         {
            param1.target.y = param1.target.y + 2.33;
         }
      }
      
      public function initDrag(param1:MovieClip) : *
      {
         param1.addEventListener(MouseEvent.MOUSE_DOWN,this.startADrag);
         stage.addEventListener(MouseEvent.MOUSE_UP,this.stopADrag);
      }
      
      function frame2() : *
      {
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong2.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong3.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      public function hit(param1:MouseEvent) : void
      {
         this.myTimer2.removeEventListener(TimerEvent.TIMER,this.action);
         this.myTimer2.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset);
         this.myTimer2.stop();
         this.winsound.play();
         nextFrame();
      }
      
      function frame15() : *
      {
         if(this.lives == 2)
         {
            this.heart1.visible = false;
         }
         if(this.lives == 1)
         {
            this.heart1.visible = false;
            this.heart2.visible = false;
         }
         this.loss = 1;
         this.timeout = 0;
         this.countdown2 = 10;
         this.win.addEventListener(MouseEvent.CLICK,this.intime);
         this.myTimer5 = new Timer(1000,10);
         this.myTimer5.addEventListener(TimerEvent.TIMER_COMPLETE,this.reset6);
         this.myTimer5.addEventListener(TimerEvent.TIMER_COMPLETE,this.action6);
         this.myTimer5.start();
         this.currentObject = null;
         this.initDrag(this.stop1);
         this.initDrag(this.stop2);
         this.initDrag(this.stop3);
         this.initDrag(this.stop4);
         this.initDrag(this.stop5);
         this.initDrag(this.stop6);
         this.initDrag(this.stop7);
         this.initDrag(this.stop8);
         this.initDrag(this.stop9);
         this.initDrag(this.stop10);
         this.myTimer5.addEventListener(TimerEvent.TIMER,this.action6);
      }
      
      function frame20() : *
      {
         if(this.lives == 2)
         {
            this.heart1.visible = false;
         }
         if(this.lives == 1)
         {
            this.heart1.visible = false;
            this.heart2.visible = false;
         }
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong2.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong3.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      function frame17() : *
      {
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong2.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong3.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      function frame23() : *
      {
         this.restartbutton.addEventListener(MouseEvent.CLICK,this.restart2);
      }
      
      function frame24() : *
      {
         this.restartbutton.addEventListener(MouseEvent.CLICK,this.restart);
      }
      
      function frame1() : *
      {
         this.bgmusic = new bmcMusic();
         this.bgmusic.play();
         this.wrongsound = new gunshottt();
         this.winsound = new correctsound();
         stop();
         this.lives = 3;
         this.startbutton.addEventListener(MouseEvent.CLICK,this.correctfun);
      }
      
      function frame3() : *
      {
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong2.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong3.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      function frame10() : *
      {
         this.myTimer2 = new Timer(520,10);
         this.myTimer2.start();
         this.myTimer2.addEventListener(TimerEvent.TIMER,this.action2);
         this.myTimer2.addEventListener(TimerEvent.TIMER_COMPLETE,this.reset2);
         this.wine.addEventListener(MouseEvent.CLICK,this.hit);
         stop();
      }
      
      function frame13() : *
      {
         this.myTimer3 = new Timer(500,5);
         this.myTimer3.addEventListener(TimerEvent.TIMER_COMPLETE,this.reset4);
         this.myTimer3.start();
      }
      
      function frame21() : *
      {
         if(this.lives == 2)
         {
            this.heart1.visible = false;
         }
         if(this.lives == 1)
         {
            this.heart1.visible = false;
            this.heart2.visible = false;
         }
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong2.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong3.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      function frame5() : *
      {
         this.win.addEventListener(MouseEvent.CLICK,this.correctfun);
         this.wrong1.addEventListener(MouseEvent.CLICK,this.wrongfun);
         this.wrong2.addEventListener(MouseEvent.CLICK,this.wrongfun);
      }
      
      public function endDrag(param1:MovieClip) : *
      {
         param1.removeEventListener(MouseEvent.MOUSE_DOWN,this.startADrag);
         stage.removeEventListener(MouseEvent.MOUSE_UP,this.stopADrag);
      }
      
      public function wrongfun(param1:MouseEvent = null) : void
      {
         this.wrongsound.play();
         this.lives--;
         if(this.lives == 2)
         {
            this.heart1.visible = false;
         }
         if(this.lives == 1)
         {
            this.heart1.visible = false;
            this.heart2.visible = false;
         }
         if(this.lives <= 0)
         {
            stage.removeEventListener(MouseEvent.MOUSE_MOVE,this.moveBall);
            gotoAndStop(24);
         }
      }
      
      public function playerPaddle(param1:Event) : void
      {
         param1.target.y = mouseY - param1.target.height / 2 + 150;
      }
      
      public function action2(param1:TimerEvent) : *
      {
         this.num = Math.floor(Math.random() * 10) + 1;
         if(this.num == 1)
         {
            this.wine.x = 640;
            this.wine.y = 650;
            this.wine.scaleX = 2;
            this.wine.scaleY = 2;
            this.wine.rotation = 1;
         }
         if(this.num == 2)
         {
            this.wine.x = 856;
            this.wine.y = 247;
            this.wine.scaleX = 1.5;
            this.wine.scaleY = 1.5;
            this.wine.rotation = -53;
         }
         if(this.num == 3)
         {
            this.wine.x = 300;
            this.wine.y = 300;
            this.wine.scaleX = 1;
            this.wine.scaleY = 1;
            this.wine.rotation = 0;
         }
         if(this.num == 4)
         {
            this.wine.x = 655.3;
            this.wine.y = 424.3;
            this.wine.scaleX = 1.5;
            this.wine.scaleY = 1.5;
            this.wine.rotation = 0;
         }
         if(this.num == 5)
         {
            this.wine.x = 190;
            this.wine.y = 17.5;
            this.wine.scaleX = 2.5;
            this.wine.scaleY = 2.5;
            this.wine.rotation = 90;
         }
         if(this.num == 6)
         {
            this.wine.x = 40.9;
            this.wine.y = 702.6;
            this.wine.scaleX = 0.5;
            this.wine.scaleY = 0.5;
            this.wine.rotation = 90;
         }
         if(this.num == 7)
         {
            this.wine.x = 1183;
            this.wine.y = 135.2;
            this.wine.scaleX = 0.5;
            this.wine.scaleY = 0.5;
            this.wine.rotation = 83;
         }
         if(this.num == 8)
         {
            this.wine.x = 1007;
            this.wine.y = 610;
            this.wine.scaleX = 0.75;
            this.wine.scaleY = 0.75;
            this.wine.rotation = 0;
         }
         if(this.num == 9)
         {
            this.wine.x = 640;
            this.wine.y = 360;
            this.wine.scaleX = 1;
            this.wine.scaleY = 1;
            this.wine.rotation = -69;
         }
         if(this.num == 10)
         {
            this.wine.x = 792;
            this.wine.y = 348;
            this.wine.rotation = 0;
         }
      }
      
      public function reset2(param1:TimerEvent) : *
      {
         this.myTimer2.start();
      }
      
      public function reset3(param1:TimerEvent) : *
      {
         if(this.offbut == 0)
         {
            this.myTimer2.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset3);
            this.win.removeEventListener(MouseEvent.MOUSE_DOWN,this.starthold);
            this.win.removeEventListener(MouseEvent.MOUSE_OUT,this.offbutton);
            this.win.removeEventListener(MouseEvent.MOUSE_UP,this.offbutton);
            this.winsound.play();
            nextFrame();
         }
      }
      
      public function reset4(param1:TimerEvent) : *
      {
         this.myTimer3.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset4);
         nextFrame();
      }
      
      public function reset5(param1:TimerEvent) : *
      {
         this.myTimer4.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset5);
         nextFrame();
      }
      
      public function reset6(param1:TimerEvent) : *
      {
         this.myTimer5.stop();
         this.lives--;
         this.lives--;
         this.lives--;
         this.win.removeEventListener(MouseEvent.CLICK,this.intime);
         this.myTimer5.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset6);
         this.myTimer5.removeEventListener(TimerEvent.TIMER,this.action6);
         this.timeout = 5;
         this.wrongfun();
      }
      
      public function wingame(param1:Event) : void
      {
         gotoAndStop(23);
      }
      
      public function correctfun(param1:MouseEvent) : void
      {
         this.winsound.play();
         nextFrame();
      }
      
      public function action6(param1:TimerEvent) : void
      {
         if(this.timeout == 0)
         {
            this.countdown2--;
            if(this.countdown >= 1)
            {
               this.myText2.text = String(this.countdown2);
            }
         }
      }
      
      public function skipnclean(param1:MouseEvent) : void
      {
         stage.removeEventListener(MouseEvent.MOUSE_MOVE,this.moveBall);
         this.myTimer.removeEventListener(TimerEvent.TIMER,this.action);
         this.myTimer.removeEventListener(TimerEvent.TIMER_COMPLETE,this.reset);
         nextFrame();
      }
      
      public function startADrag(param1:MouseEvent) : void
      {
         this.currentObject = MovieClip(param1.target);
         var _loc2_:Rectangle = new Rectangle(0,0,stage.stageWidth - this.currentObject.width,stage.stageHeight - this.currentObject.height);
         this.currentObject.startDrag(false,_loc2_);
      }
   }
}
