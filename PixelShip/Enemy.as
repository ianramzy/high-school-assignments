package
{
   import flash.display.MovieClip;
   import flash.events.Event;
   
   public class Enemy extends MovieClip
   {
       
      
      private var dx;
      
      private var dy;
      
      private var rote;
      
      public function Enemy(param1:Number, param2:Number)
      {
         this.dx = Math.random() * 5 - 2;
         this.dy = Math.random() * 5 - 2;
         this.rote = this.dx / this.dy * 260;
         super();
         this.addEventListener(Event.ENTER_FRAME,this.moveMe);
         this.x = param1;
         this.y = param2;
         this.rotation = this.rote;
      }
      
      function moveMe(param1:Event) : *
      {
         x = x + this.dx;
         y = y + this.dy;
         if(x < 0)
         {
            x = x + stage.stageWidth;
         }
         if(x > stage.stageWidth)
         {
            x = x - stage.stageWidth;
         }
         if(y < 0)
         {
            y = y + stage.stageHeight;
         }
         if(y > stage.stageHeight)
         {
            y = y - stage.stageHeight;
         }
      }
      
      public function remove() : *
      {
         parent.removeChild(this);
         this.removeEventListener(Event.ENTER_FRAME,this.moveMe);
      }
   }
}
