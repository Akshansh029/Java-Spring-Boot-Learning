package practice;

import java.util.ArrayList;

/*
Problem Statement
Create:
- Interface EventListener
      - void onEvent(String eventName);
- Class EventManager

Task
- Register event listeners using anonymous inner classes
- Trigger events dynamically
 */

interface EventListener{
      void onEvent(String eventName);
}

class EventManager {
      private ArrayList<EventListener> listeners = new ArrayList<>();
  
      public void registerListener(EventListener listener) {
          listeners.add(listener);
      }
  
      public void triggerEvent(String eventName) {
          for (EventListener listener : listeners) {
              listener.onEvent(eventName);
          }
      }
  }
  

  public class EventNotiSystem {
      public static void main(String[] args) {
  
          EventManager manager = new EventManager();
  
          manager.registerListener(new EventListener() {
              @Override
              public void onEvent(String eventName) {
                  System.out.println("Event received: " + eventName);
              }
          });
  
          String[] events = {"Pushed", "Pulled", "Queued", "Subscribed"};
  
          for (String event : events) {
              manager.triggerEvent(event);
          }
      }
  }
  
