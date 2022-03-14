package edu.wctc;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
public class VennDiagram<T> {
    public String CIRCLEONE;
    Set<T> CIRCLEONEINFO = new HashSet<>();
    public String CIRCLETWO;
    Set<T> CIRCLETWOINFO = new HashSet<>();
    public String CIRCLETHREE;
    Set<T> CIRCLETHREEINFO = new HashSet<>();
    public VennDiagram(String label1, String label2, String label3) {
        this.CIRCLEONE = label1;
        this.CIRCLETWO = label2;
        this.CIRCLETHREE = label3;
    }
    public void add(T item, String... labels) {
        for (String label : labels) {
            if (label.equals(this.CIRCLETWO)) {
                CIRCLETWOINFO.add(item);
            } else if (label.equals(this.CIRCLETHREE)) {
                CIRCLETHREEINFO.add(item);
            }
        }
    }
    private Set<T> getCircleForLabel(String label) {
        if (label.equals(this.CIRCLEONE)) {
            return CIRCLEONEINFO;
        } else if (label.equals(this.CIRCLETWO)) {
            return CIRCLETWOINFO;
        } else if (label.equals(this.CIRCLETHREE)) {
            return CIRCLETHREEINFO;
        }
        return null;
    }
    public Set<T> diagramCenter() {
        Iterator<T> it = CIRCLEONEINFO.iterator();
        Set<T> centerSet = new HashSet<>();
        while(it.hasNext()){
            T item = it.next();
            if (CIRCLETWOINFO.contains(item) && CIRCLETHREEINFO.contains(item)) {
                centerSet.add(item);
            }
        }
        return centerSet;
    }
    public Set<T> complementOf(String first, String second) {
        Iterator<T> it = Objects.requireNonNull(getCircleForLabel(first)).iterator();
        Set<T> firstNotSecond = new HashSet<>();
        Set<T> secondCircle = getCircleForLabel(second);
        while(it.hasNext()) {
            T item = it.next();
            if (!Objects.requireNonNull(secondCircle).contains(item)) {
                firstNotSecond.add(item);
            }
        }
        return firstNotSecond;
    }
    public Set<T> unionOf(String first, String second) {
        Iterator<T> it = Objects.requireNonNull(getCircleForLabel(first)).iterator();
        Iterator<T> it2 = Objects.requireNonNull(getCircleForLabel(second)).iterator();
        Set<T> unionCircle = new HashSet<>();
        while(it.hasNext()) {
            unionCircle.add(it.next());
        }
        while(it2.hasNext()) {
            unionCircle.add(it2.next());
        }
        return unionCircle;
    }
    public Set<T> intersectionOf(String first, String second) {
        Iterator<T> it = Objects.requireNonNull(getCircleForLabel(first)).iterator();
        Set<T> firstAndSecond = new HashSet<>();
        Set<T> secondCircle = getCircleForLabel(second);
        while(it.hasNext()) {
            T item = it.next();
            if (Objects.requireNonNull(secondCircle).contains(item)) {
                firstAndSecond.add(item);
            }
        }
        return firstAndSecond;
    }
}