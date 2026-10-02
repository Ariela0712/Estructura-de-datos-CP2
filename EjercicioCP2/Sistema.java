public class Sistema {
    private LinkedList<String> lista;
    private Validaciones val;

    public Sistema() {
        this.lista = new LinkedList<>();
        this.val = new Validaciones();
    }

    public void iniciar() {
        int op = -1;
        while (op != 0) {
            mostrarMenu();
            op = val.validarEntero("Elige una opción: ",0,9);

            if (op == 1) {
                agregarFinal();
            } else if(op == 2) {
                agregarEnPosicion();
            } else if(op == 3) {
                eliminarPosicion();
            } else if(op == 4) {
                mostrar("Lista actual",lista);
            } else if(op == 5) {
                eliminarRepetidos();
            } else if(op == 6) {
                rotar();
            } else if (op == 7) {
                concatenar();
            } else if(op == 8) {
                vaciar();
            } else if(op == 9) {
                ejecutarPruebas();
            } else {
                System.out.println("Saliendo del sistema....");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\nLISTA SIMPLEMENTE ENLAZADA");
        System.out.println("1. Agregar elemento al final");
        System.out.println("2. Agregar elemento en una posicion");
        System.out.println("3. Eliminar elemento por posicion");
        System.out.println("4. Mostrar lista");
        System.out.println("5. Eliminar elementos repetidos");
        System.out.println("6. Rotar una posición a la derecha");
        System.out.println("7. Concatenar con otra lista");
        System.out.println("8. Vaciar lista");
        System.out.println("9. Ejecutar casos de prueba");
        System.out.println("0. Salir");
    }

    private void agregarFinal() {
        String elemento = val.validarTexto("Elemento: ");
        lista.add(elemento);
        System.out.println("Elemento agregado.");
    }

    private void agregarEnPosicion() {
        String elemento = val.validarTexto("Elemento: ");
        int pos = val.validarEntero("Posición (0 a " +lista.size()+"): ",0,lista.size());
        lista.add(elemento, pos);
        System.out.println("Elemento agregado.");
    }

    private void eliminarPosicion() {
        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia.");
        } else {
            int pos = val.validarEntero("Posición (0 a " + (lista.size()-1) + "): ", 0, lista.size()-1);
            String eliminado = lista.remove(pos);
            System.out.println("Se eliminó: " + eliminado);
        }
    }

    private void eliminarRepetidos() {
        lista.removeDuplicates();
        mostrar("Sin repetidos", lista);
    }

    private void rotar() {
        lista.rotateRight();
        mostrar("Rotada", lista);
    }

    private void concatenar() {
        LinkedList<String> otra = new LinkedList<>();
        int cantidad = val.validarEntero("Cuantos elementos tiene la segunda lista? (0 a 20): ", 0, 20);
        for (int i=0;i<cantidad;i++) {
            otra.add(val.validarTexto("Elemento "+(i + 1)+ ": "));
        }
        lista.concatenate(otra);
        mostrar("Resultado", lista);
    }

    private void vaciar() {
        lista.clear();
        System.out.println("Lista vaciada.");
    }

    private void ejecutarPruebas() {
        System.out.println("\n1. Metodo removeDuplicates");
        LinkedList<String> p1 = crear("A","B","A","C","B","D","A");
        mostrar("Antes   ", p1);
        p1.removeDuplicates();
        mostrar("Después ", p1);        

        LinkedList<String> p2 = crear("X","X","X","X");
        p2.removeDuplicates();
        mostrar("Todos iguales", p2);  

        LinkedList<String> p3 = new LinkedList<>();
        p3.removeDuplicates();
        mostrar("Lista vacía", p3); 

        System.out.println("\n2. Metodo rotateRight");
        LinkedList<String> p4 = crear("A","B","C","D");
        mostrar("Antes ",p4);
        p4.rotateRight();
        mostrar("Después ",p4);      

        LinkedList<String> p5 = crear("A");
        p5.rotateRight();
        mostrar("Un elemento", p5);   

        LinkedList<String> p6 = new LinkedList<>();
        p6.rotateRight();
        mostrar("Lista vacía", p6);  

        System.out.println("\n3.Metodo concatenate");
        LinkedList<String> p7 = crear("A","B","C","D");
        LinkedList<String> p8 = crear("E","F","G","H");
        p7.concatenate(p8);
        mostrar("Concatenación: A-B-C-D + E-F-G-H", p7);

        LinkedList<String> p9 = new LinkedList<>();
        p9.concatenate(crear("X","Y"));
        mostrar("Concatenacion: vacía + X-Y",p9);

        LinkedList<String> p10 = crear("X","Y");
        p10.concatenate(new LinkedList<>());
        mostrar("Concatenación: X-Y + vacía", p10);  

        System.out.println("\nExtra: clear");
        LinkedList<String> p11 = crear("A","B","C");
        p11.clear();
        mostrar("Después de clear",p11);
        p11.add("Z");
        mostrar("Añado Z",p11); 
    }

    private LinkedList<String> crear(String... elementos) {
        LinkedList<String> nueva = new LinkedList<>();
        for (int i=0;i<elementos.length; i++) {
            nueva.add(elementos[i]);
        }
        return nueva;
    }

    private void mostrar(String titulo,LinkedList<String> l) {
        String texto = "";
        for (int i=0;i<l.size();i++) {
            texto = texto + l.get(i);
            if (i<l.size()-1) {
                texto = texto + "-";
            }
        }
        if (l.isEmpty()) {
            texto = "(vacía)";
        }
        System.out.println(titulo + ": "+texto+"  [size: " +l.size()+"]");
    }
}
