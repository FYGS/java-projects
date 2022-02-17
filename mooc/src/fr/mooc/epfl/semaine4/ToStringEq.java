package fr.mooc.epfl.semaine4;

class ToStringEq
{
	
	public static void main(String[] args)
		{
			System.out.println("Test 1 :");
			Rectangle rect = new Rectangle(12.5, 4.0);
			System.out.println(rect);
			System.out.println();
			
			System.out.println("Test 2: ");
			// le type de rect1 est RectangleColore 
			// l'objet contenu dans rect1 est de type RectangleColore
			RectangleColore rect1 = new RectangleColore(12.5, 4.0, "rouge");
			System.out.println(rect1);
			System.out.println();

			System.out.println("Test 3 :");

            // le type de rect2 est Rectangle 
			// l'objet contenu dans rect2 est de type RectangleColore
			Rectangle  rect2 = new RectangleColore(25.0/2, 8.0/2, new String("rouge"));
			System.out.println(rect2);

			System.out.println (rect1.equals(rect2)); // 1.
			System.out.println (rect2.equals(rect1)); // 2.
			System.out.println(rect1.equals(null));   // 3.
			System.out.println (rect.equals(rect1));  // 4.
			System.out.println (rect1.equals(rect));  // 5.
		}
}
