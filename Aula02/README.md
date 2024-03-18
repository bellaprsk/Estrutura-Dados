### Vector:
  - Estrutura de dados que implementa uma lista de objetos. Trabalha como um vetor/array, onde novos registros são realizados no final da lista e temos flexibilidade para manipular qualquer informação através do índice do vetor.

  Ex.:
  Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("Python");
        vector.add("C++");
        System.out.println("Vector: " + vector);

### ArrayList:
  - Possui as mesmas características do Vector, porém sua estrutura foi melhorada.

  Ex.:
  ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("ArrayList: " + arrayList);

### LinkedList:
  - Sua estrutura garante mais segurança no encadeamento de dados. O LinkedList é mais performatic que o ArrayList para alterar registros, porém mais lento em outras funções.

  Ex.:
  LinkedList<Double> linkedList = new LinkedList<>();
        linkedList.add(3.14);
        linkedList.add(2.71);
        linkedList.add(1.618);
        System.out.println("LinkedList: " + linkedList);

### HashMap:
  - É uma implementação de interface Map na qual você pode armazenar objetos associados a uma chave correspondente. O HashMap não pode ter chaves duplicadas.

  Ex.:
  HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("um", 1);
        hashMap.put("dois", 2);
        hashMap.put("três", 3);
        System.out.println("HashMap: " + hashMap);