public class Lista {
    private Nodo head;
    private Nodo tail;

    public Lista() {
        this.head = null;
        this.tail = null;
    }

    // ricerca
    public Nodo search(Nodo nodoCerc){
        if(head == null || head.getNext() == tail){
            return null;
        }
        Nodo curNodo = head;
        while(!curNodo.getNext().equals(tail)){
            if(curNodo.equals(nodoCerc)){
                return curNodo;
            }
            curNodo = curNodo.getNext();
        }
        return null;
    }

    // inserimento
    public void insInTesta(Nodo nuovoNodo) {
        if(head == null){
            head = nuovoNodo;
            tail = head;
            return;
        }
        head.setPrevious(nuovoNodo);
        nuovoNodo.setNext(head);
        head = nuovoNodo;
    }

    public void insInMezzo(Nodo nuovoNodo, Nodo nodoPrev){
        if(head == null){
            head = nuovoNodo;
            tail = head;
            return;
        }
        nuovoNodo.setPrevious(nodoPrev);
        nuovoNodo.setNext(nodoPrev.getNext());
        nodoPrev.getNext().setPrevious(nuovoNodo);
        nodoPrev.setNext(nuovoNodo);
    }

    public void insInCoda(Nodo nuovoNodo){
        if(head == null){
            head = nuovoNodo;
            tail = head;
            return;
        }
        nuovoNodo.setPrevious(tail);
        tail.setNext(nuovoNodo);
        tail = nuovoNodo;
    }

    // cancellazione
    public boolean cancInTesta(){
        if(head == null){
            return false;
        }
        Nodo pAux = head.getNext();
        head.getNext().setPrevious(null);
        head.setNext(null);
        head = pAux;
        return true;
    }

    public boolean cancInMezzo(Nodo nodoCerc){
        if(head == null){
            return false;
        }
        if(search(nodoCerc) == null){
            return false;
        }
        Nodo pAux;

        pAux = nodoCerc.getNext();
        pAux.setPrevious(nodoCerc.getPrevious());
        nodoCerc.setPrevious(null);

        pAux = nodoCerc.getPrevious();
        pAux.setNext((nodoCerc.getNext()));
        nodoCerc.setNext(null);
        return true;
    }

    public boolean cancInCoda(){
        if(head == null){
            return false;
        }
        Nodo pAux = tail.getPrevious();
        pAux.setNext(null);
        tail.setPrevious(null);
        tail = pAux;
        return true;
    }
}