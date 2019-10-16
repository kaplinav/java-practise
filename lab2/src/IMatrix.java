/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
/**
* Интерфейс представляет методы, которые должны реализовать классы,
* представляющие матрицу.
*
* @author Ю.Д.Заковряшин, 2014
*/

public interface IMatrix {
 /**
 * Метод складывает две матрицы одинакового размера.
 *
 * @param other ссылка на вторую матрицу
 * @return матрицу, являющуюся результатом сложения текущей матрицы и
 * матрицы other.
 * @throws MatrixException Исключение выбрасывается в случае, если хотя бы
 * одна из матриц не содержит данных (ссылка равна null) или матрицы имеют
 * разные размеры.
 *
 */
 IMatrix add(IMatrix other) throws MatrixException;
 /**
 * Метод сравнивает две матрицы на равенство.
 *
 * @param other ссылка на матрицу, с которой сравнивается данная матрица
 * @return true, если матрицы строго равны, false - в случае, если матрицы
 * имеют разный размер или хотя бы один элемент данной матрицы не равен
 * соответствующему элементу матрицы other
 * @throws MatrixException выбрасывает в случае, если ссылка на матрицу
 * other равна null.
 */
 boolean equals(IMatrix other) throws MatrixException;
 /**
 * Метод позволяет получить заданный элемент матрицы.
 *
 * @param i индекс строки матрицы.
 * @param j индекс столбца матрицы.
 * @return значение заданного элемента матрицы.
 * @throws MatrixException выбрасывает в случае, если индексы строки и
 * столбца заданы неправильно.
 */
 int get(int i, int j) throws MatrixException;
 /**
 * Метод выводит матрицу на экран.
 */
 void output();
 /**
 * Метод считывает матрицу из заданного файла.
 *
 * @param file имя файла.
 * @return ссылка на объект матрицы, содержащей считанные значения
 * @throws IOException выбрасывает в случае, если матрица
 *
 */
 IMatrix read(String file) throws IOException;
 /**
 * Метод позволяет задать значение определённого элемента матрицы.
 *
 * @param i индекс строки матрицы.
 * @param j индекс столбца матрицы.
 * @param value значение элемента матрицы.
 * @return значение заданного элемента матрицы.
 * @throws MatrixException выбрасывает в случае, если индексы строки и
 * столбца заданы неправильно.
 */
 int set(int i, int j, int value) throws MatrixException;
 /**
 * Метод записывает данную матрицу в заданный файл.
 *
 * @param file имя файла, в который записывается матрица.
 * @throws IOException выбрасывает в случае, если матрица не записана в файл
 * по любой причине
 */
 void write(String file) throws IOException;
}
