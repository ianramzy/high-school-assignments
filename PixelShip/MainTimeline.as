package PixelShip_fla
{
   import flash.display.MovieClip;
   import flash.display.SimpleButton;
   import flash.events.Event;
   import flash.events.MouseEvent;
   import flash.media.Sound;
   import flash.text.TextField;
   
   public dynamic class MainTimeline extends MovieClip
   {
       
      
      public var restartbutton:SimpleButton;
      
      public var finalText:TextField;
      
      public var lives:Number;
      
      public var enemy:Enemy;
      
      public var bullet:Bullet;
      
      public var hit:Number;
      
      public var startbutton:SimpleButton;
      
      public var score:Number;
      
      public var scoreText:TextField;
      
      public var music:Sound;
      
      public var enemies:Array;
      
      public var character:Character;
      
      public var heart1:MovieClip;
      
      public var heart2:MovieClip;
      
      public var heart3:MovieClip;
      
      public var i:int;
      
      public var bullets:Array;
      
      public function MainTimeline()
      {
         super();
         addFrameScript(0,this.frame1,1,this.frame2,2,this.frame3);
      }
      
      public function hitTest(param1:Event) : void
      {
         for each(this.bullet in this.bullets)
         {
            if(this.bullet.parent == null)
            {
               this.bullets.splice(this.bullets.indexOf(this.bullet),1);
            }
            else
            {
               for each(this.enemy in this.enemies)
               {
                  if(this.enemy != null && this.bullet.hitTestObject(this.enemy))
                  {
                     this.enemies.splice(this.enemies.indexOf(this.enemy),1);
                     this.enemy.remove();
                     this.score++;
                     this.scoreText.text = "Score: " + this.score;
                     this.enemy = new Enemy(Math.random() * stage.stageWidth,Math.random() * stage.stageHeight);
                     addChild(this.enemy);
                     this.enemies.push(this.enemy);
                     this.enemy = new Enemy(Math.random() * stage.stageWidth,Math.random() * stage.stageHeight);
                     addChild(this.enemy);
                     this.enemies.push(this.enemy);
                     this.enemy = null;
                     this.bullets.splice(this.bullets.indexOf(this.bullet),1);
                     this.bullet.remove();
                     break;
                  }
               }
            }
         }
      }
      
      public function restart(param1:MouseEvent) : void
      {
         gotoAndStop(1);
      }
      
      public function correctfun(param1:MouseEvent) : void
      {
         gotoAndStop(2);
      }
      
      public function checkHitship(param1:Event) : void
      {
         for each(this.enemy in this.enemies)
         {
            if(this.enemy.hitTestObject(this.character))
            {
               this.enemies.splice(this.enemies.indexOf(this.enemy),1);
               this.enemy.remove();
               this.enemy = null;
               this.lives--;
               if(this.lives == 2)
               {
                  this.heart1.visible = false;
               }
               if(this.lives == 1)
               {
                  this.heart2.visible = false;
               }
               if(this.lives == 0)
               {
                  for each(this.enemy in this.enemies)
                  {
                     this.enemy.remove();
                  }
                  nextFrame();
               }
               break;
            }
         }
      }
      
      function frame1() : *
      {
         stop();
         this.startbutton.addEventListener(MouseEvent.CLICK,this.correctfun);
      }
      
      function frame2() : *
      {
         this.bullet = null;
         this.bullets = new Array();
         this.enemies = new Array();
         this.character = new Character(this.bullets);
         addChild(this.character);
         this.enemy = null;
         this.hit = 0;
         this.score = 0;
         this.lives = 3;
         this.character.x = 200;
         this.character.y = 200;
         this.music = new Bgmusic();
         this.music.play();
         this.i = 0;
         while(this.i < 4)
         {
            this.enemy = new Enemy(Math.random() * stage.stageWidth,Math.random() * stage.stageHeight);
            addChild(this.enemy);
            this.enemies.push(this.enemy);
            this.i++;
         }
         stage.addEventListener(Event.ENTER_FRAME,this.hitTest);
         stage.addEventListener(Event.ENTER_FRAME,this.checkHitship);
      }
      
      function frame3() : *
      {
         this.finalText.text = "" + this.score;
         stop();
         this.restartbutton.addEventListener(MouseEvent.CLICK,this.restart);
         this.character.remove();
         for each(this.bullet in this.bullets)
         {
            this.bullet.remove();
         }
         this.bullets = [];
      }
   }
}
