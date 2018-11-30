package application.android.com.expencestracker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.Date;
import java.util.List;

import application.android.com.expencestracker.DBImp.ExpenseDaoImpl;
import application.android.com.expencestracker.Model.Expense;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class ExpenseDaoImplTest {
    ExpenseDaoImpl expenseDao;
    @Before
    public void setUp() throws Exception {
        expenseDao = new ExpenseDaoImpl(RuntimeEnvironment.application);
    }

    @Test
    public void add() {
        Expense e=new Expense(10,"Rent", new Date(), 10);
        expenseDao.add(e);
        List<Expense> expenses = expenseDao.getExpenseList(" where user=10;");
        assertTrue(expenses.size() == 1);
        assertTrue(expenses.get(0).getAmount()==e.getAmount());
        assertTrue(expenses.get(0).getCategory().equals(e.getCategory()));

        assertTrue(expenses.get(0).getUser()==e.getUser());
       
    }


}