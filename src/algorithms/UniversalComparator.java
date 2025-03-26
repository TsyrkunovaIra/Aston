package src.algorithms;

import src.customs.Bus;
import src.customs.Student;
import src.customs.User;

import java.util.Comparator;

public class UniversalComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        String className1 = o1.getClass().getSimpleName();
        String className2 = o2.getClass().getSimpleName();

        int classComparison = className1.compareTo(className2);
        if (classComparison != 0) {
            return classComparison;
        }

        if (o1 instanceof Bus && o2 instanceof Bus) {
            return Integer.compare(((Bus) o1).getNumber(), ((Bus) o2).getNumber());
        } else if (o1 instanceof Student && o2 instanceof Student) {
            return Integer.compare(((Student) o1).getAverageGrade(), ((Student) o2).getAverageGrade());
        } else if (o1 instanceof User && o2 instanceof User) {
            return extractUserNumber(((User) o1).getName()) - extractUserNumber(((User) o2).getName());
        }

        return 0;
        }


    private int extractUserNumber(String name) {
        return Integer.parseInt(name.replaceAll("\\D+", "")); // Remove non-numeric characters
    }
}