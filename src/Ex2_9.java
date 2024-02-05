
public class Ex2_9 {
 public static void main(String[] args) {}
}


interface Sellable{
 String getName();
  double getPrice();

}
interface Package<T>{
	 T extract();
	 boolean pack(T item);
	 boolean isEmpty();
	 double getPriority();
}
interface Wrappable extends Sellable{

	
}
interface Common <T>{
	 boolean isEmpty();
	 T peek();
	 int size(); 
}
interface Node<T>{
	int DEFAULT_CAPACITY=2;
    void setNext(T item);
	T getNext();
	double getPriority();
	
	
}
interface Stack <T>extends Common<T>{
	 boolean push(T item);
	 T pop();
}
interface PriorityQueue<T> extends Common<T>{
	int FLEET_CAPACITY = 3;
	boolean enqueue(T item);
	T dequeue();
	
}
 abstract class Product implements Sellable{
	 private String name;
	 private double price;
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	 public String toString() {
		 return this.getClass()+"("+name+","+price+")";
	 }
	 public String getName(){
		return name;
	 }
	 public double getPrice() {
		 return price;
	 }
 }
 
 
 class Mirror extends Product{
	 private int width;
	 private int height;
	 public Mirror(int width, int height) {
	        super("mirror", 2);
	        this.width = width;
	        this.height = height;
	    }
	public int getArea(){
		return (width)*height;
	}
	public  <T> T reflect(T item) {
		return item;
	}
	
 } 
	class Paper extends Product implements Wrappable{
		private String note;

		public Paper(String name, double price, String note) {
			super("A4",2);
			this.note = note;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

   
	}
	class Matroschka <T extends Wrappable> extends Product implements Wrappable,Package <T>{
		private T item;
		public Matroschka(T item){
			super("Doll",5+item.getPrice());
			this.item=item;
		}
		public String toString() {
			return super.toString()+"{" + item.toString() + "}";
		}
		
		@Override
		public T extract() {
			T item1=item;
			item=null;
			return item1;
		}
		@Override
		public boolean pack(T item) {
		    if(isEmpty()){
		        this.item = item;
		      return true;
		        }
		        return false;
		}
		@Override
		public boolean isEmpty() {
			return item == null;
		}
		@Override
		public double getPriority() {
			 throw new UnsupportedOperationException("Not implemented");
		}
	}
	class Box <T extends Sellable> implements Package <T>{
		private T item;
		private boolean seal;
		private int distanceToAdress;
		public Box() {
			this.item = null;
			this.seal = false;
		}
		
		public Box(T item,int distanceToAdress) {
			this.item = item;
			this.seal = true;
			this.distanceToAdress=distanceToAdress;
		}
		public String toString() {
	        return getClass().getSimpleName()+" {" + item + "} Seal: "+seal;
	    }

		@Override
		public T extract() {
			this.seal=false;
			T item1=item;
			item=null;
			return item1;
			
		}
		@Override
		public boolean pack(T item) {
			 if(isEmpty()){
			    this.item = item;
			    seal=true;
			    return true;
			        }
			   return false;
		}
		@Override
		public boolean isEmpty() {
			return item == null;
		}

		@Override
		public double getPriority() {
			return distanceToAdress/item.getPrice();
		}	 
	}
	class Container implements Stack<Box<?>>,Node<Container>,Comparable<Container>{
		private int top;
		private int size;
		private double priority;
		private Container next;
		private Box<?>[] boxes;
		
		public Container() {
		    this.boxes = new Box<?>[DEFAULT_CAPACITY];
		    this.top = -1;
		    this.size = 0;
		    this.priority = 0;
		    this.next = null;
		    }

		@Override
		public boolean isEmpty() {
			return size==0;
		}

		@Override
		public Box<?> peek() {
			if(isEmpty())
			return null;
		return boxes[top];
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public int compareTo(Container o) {
			if(priority<o.priority)
			return 1;
			else if (priority>o.priority){
				return -1;
			}
			else 
				return 0;
		}

		@Override
		public Container getNext() {
			return next;
		}

		@Override
		public double getPriority() {
			return priority;
		
		}

		@Override
		public boolean push(Box<?> item) {
			int capacity=DEFAULT_CAPACITY;
	      if (capacity>size) {
		        boxes[++top]=item;
		        size++;
		        return true;}
		        else return false;
		    }

		@Override
		public void setNext(Container item) {
             this.next=item;		
		}

		@Override
		public Box<?> pop() {
			if(isEmpty())
			return null;
			Box popped=boxes[top];
			boxes[top]=null;
			top--;
			size--;
	        return popped;
		}
		public String toString() {
	        return "Container with priority:" + priority;
	    }

		}
		
	
	class CargoFleet implements PriorityQueue <Container>{
		private Container head;
		private int size;
		public CargoFleet() {
			this.head=null;
			this.size=0;
		}
		@Override
		public boolean isEmpty() {
			  return size == 0;
		}
		@Override
		public Container peek() {
			if(isEmpty())
				return null;
			return head;
			
		}
		@Override
		public int size() {
			return size;
		}
		@Override
		public boolean enqueue(Container item) {
			if(item == null)
	         return false;
	          if(head==null)
	            head=item;
	        else{
	            Container now=head;
	            Container front=null;
	            while (now!=null&&item.compareTo(now)>= 0){
	                front = now;
	                now = now.getNext();
	            }
	            if (front== null) {
	                item.setNext(head);
	                head = item;
	            }
	            else {
	               front.setNext(item);
	                item.setNext(now);
	            }
	        }
	        size++;
	        return true;
		}
		@Override
		public Container dequeue() {
			if(isEmpty()) {
			return null;}
			Container item=head;
			head=head.getNext();
			 item.setNext(null);
		        size--;
		    return item;
			
		}
		
	}
	class CargoCompany{
		private Container stack;
		private CargoFleet queue;
		
		
		public CargoCompany() {
			 this.stack = new Container();
		     this.queue = new CargoFleet();
		}
		public <T> void addBox(T box) {
			if (stack==null) {
	            stack=new Container();
	        }
	        if (stack.push((Box<?>) box)) {
	          
	        }
	        else {
	            if(queue.enqueue(stack)) {
	             stack=new Container();
	                addBox(box);
	            } else{
	                ship(queue);
	            }
	        }
		}
		private void ship(CargoFleet fleet) {
			while(!fleet.isEmpty()) {
				empty(fleet.dequeue());
			}
			
		}
		private void empty(Container container) {
			while(!container.isEmpty()) {
				deliver(container.pop());
				
			}
		}
		private  Sellable deliver(Box<?> box) {
			return box.extract();
			
		}
	}
	
	  
	
	 
	 
	 
	 
	 
	 
	 
 