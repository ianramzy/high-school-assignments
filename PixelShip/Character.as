package
{
   import flash.display.MovieClip;
   import flash.events.Event;
   import flash.events.KeyboardEvent;
   import flash.ui.Keyboard;
   
   public class Character extends MovieClip
   {
       
      
      var bullet:Bullet;
      
      public var maxSpeed = 10;
      
      private var speed = 0;
      
      private var dir = 0;
      
      public var dx = 0;
      
      public var dy = 0;
      
      public var rot = 0;
      
      var reload:int = 10;
      
      private var bullets:Array;
      
      private var keysDown:Array;
      
      public var flame = 0;
      
      public function Character(param1:*)
      {
         this.keysDown = new Array();
         super();
         addFrameScript(1,this.frame2,3,this.frame4);
         this.bullets = param1;
         addEventListener(Event.ADDED_TO_STAGE,this.init);
      }
      
      private function moveMe(param1:Event) : *
      {
         this.x = this.x + this.dx;
         this.y = this.y + this.dy;
         this.rotation = this.rot;
         if(this.x < 0)
         {
            this.x = 0;
         }
         if(this.x > stage.stageWidth)
         {
            this.x = stage.stageWidth;
         }
         if(this.y < 0)
         {
            this.y = 0;
         }
         if(this.y > stage.stageHeight)
         {
            this.y = stage.stageHeight;
         }
      }
      
      private function keyPressed(param1:KeyboardEvent) : void
      {
         this.keysDown[param1.keyCode] = true;
      }
      
      public function remove() : *
      {
         stage.removeEventListener(KeyboardEvent.KEY_DOWN,this.keyPressed);
         stage.removeEventListener(KeyboardEvent.KEY_UP,this.keyReleased);
         this.removeEventListener(Event.ENTER_FRAME,this.processInput);
         this.removeEventListener(Event.ENTER_FRAME,this.moveMe);
         parent.removeChild(this);
      }
      
      function init(param1:Event) : void
      {
         stage.addEventListener(KeyboardEvent.KEY_DOWN,this.keyPressed);
         stage.addEventListener(KeyboardEvent.KEY_UP,this.keyReleased);
         this.addEventListener(Event.ENTER_FRAME,this.processInput);
         this.addEventListener(Event.ENTER_FRAME,this.moveMe);
         removeEventListener(Event.ADDED_TO_STAGE,this.init);
      }
      
      private function processInput(param1:Event) : *
      {
         if(--this.reload == 0)
         {
            this.reload = 1;
            if(this.keysDown[Keyboard.SPACE])
            {
               this.reload = 10;
               this.bullet = new Bullet(x,y,20,this.rot);
               stage.addChild(this.bullet);
               this.bullets.push(this.bullet);
            }
         }
         if(this.keysDown[Keyboard.LEFT])
         {
            this.dir = this.dir - 5;
            if(this.dir < 0)
            {
               this.dir = this.dir + 360;
            }
         }
         if(this.keysDown[Keyboard.RIGHT])
         {
            this.dir = this.dir + 5;
            if(this.dir > 360)
            {
               this.dir = this.dir - 360;
            }
         }
         if(this.keysDown[Keyboard.DOWN])
         {
            this.speed = this.speed - 1;
            this.flame = 0;
         }
         if(this.keysDown[Keyboard.UP])
         {
            this.flame = 1;
            this.speed = this.speed + 1;
         }
         if(this.speed > this.maxSpeed)
         {
            this.speed = this.maxSpeed;
         }
         else if(this.speed > 0)
         {
            this.speed = this.speed - 0.03;
         }
         else if(-this.speed > this.maxSpeed)
         {
            this.speed = -this.maxSpeed;
         }
         else if(this.speed < 0)
         {
            this.speed = this.speed + 0.1;
         }
         this.dx = this.speed * Math.cos(this.dir * Math.PI / 180);
         this.dy = this.speed * Math.sin(this.dir * Math.PI / 180);
         this.rot = this.dir;
      }
      
      function frame2() : *
      {
         if(this.flame == 0)
         {
            gotoAndPlay(1);
         }
         if(this.flame == 1)
         {
            gotoAndPlay(3);
         }
      }
      
      function frame4() : *
      {
         if(this.flame == 0)
         {
            gotoAndPlay(1);
         }
         if(this.flame == 1)
         {
            gotoAndPlay(3);
         }
      }
      
      private function keyReleased(param1:KeyboardEvent) : void
      {
         this.keysDown[param1.keyCode] = false;
      }
   }
}
