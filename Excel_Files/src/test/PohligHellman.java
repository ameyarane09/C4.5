package test;

/**
 * Title:        Example of Polig Hellman method of Discret Logs
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author Burton Rosenberg
 * @version 1.0
 */

public class PohligHellman {

    public PohligHellman() {
    }
    public static void main(String[] args) {
        PohligHellman ph = new PohligHellman();
        ph.entryPoint(12) ;
    }

    public void entryPoint(int mystery_index)
    { 
        int gen = 3 ;
        int modu = 17 ;
        int order = 16 ;

        // prove 3 generates Z/17Z
        System.out.println("Demonstrate that 3 generates Z/17Z.") ;
        this.cycle(gen,modu) ;
        System.out.println() ;

        // calculate and check gen_inv
        int gen_inv = pwr ( gen, order-1, modu ) ;
        System.out.println( gen + " * " + gen_inv + " = " + (gen*gen_inv)%17);
        System.out.println();

        setMagicPower( 2, order ) ;
        int mp = getMagicPower();
        int possible_coeff_1 = pwr( gen, mp, modu ) ;
        System.out.println("We should either get 1 or " + possible_coeff_1 +
                " during PH index extractions" ) ;

        // create mystery number
        int mystery = pwr( gen, mystery_index, modu ) ;
        System.out.println("Mystery: " + mystery );

        int coeff_index = 0 ;
        int coeff_power = 1 ;
        while ( isNextMagicPower() )
        {
            // kill all but leading term of current_factor-adic expansion
            // of index of mystery
            System.out.println("magic power: " + getMagicPower());
            int this_reduction = pwr( mystery, nextMagicPower(), modu ) ;

            System.out.println(coeff_index + ", reduction: " + this_reduction );
            if ( this_reduction==possible_coeff_1 )
            {
                // coeff is 1
                System.out.println(coeff_index + ", coeffic: " + 1 ) ;
                mystery = mystery * pwr(gen_inv,coeff_power,modu) % modu ;
                System.out.println("New mystery: "+ mystery );
            }
            else
            {
                // coeff is 0
                System.out.println(coeff_index + ", coeffic: " + 0 ) ;
            }
            coeff_index++ ;
            coeff_power *= 2 ;
        }

    }

    int pMagicPower ;
    int pCurrentFactor ;

    public void setMagicPower( int current_factor, int group_order )
    {
        // ASSERT : current_factor | group_order
        pMagicPower = group_order ;
        pCurrentFactor = current_factor ;
    }

    public boolean isNextMagicPower()
    {
        if ( pMagicPower % pCurrentFactor == 0 ) return true ;
        else return false;
    }

    public int getMagicPower()
    {
        return pMagicPower / pCurrentFactor ;
    }

    public int nextMagicPower( )
    {
        return pMagicPower = pMagicPower/pCurrentFactor ;
    }

    public int pwr(int base, int expon, int modu)
    {
        // recursive base^expon % modu
        base %= modu ;
        if (expon==0) return 1 ;
        if (expon==1) return base ;
        if ((expon%2)==0 )
        {
            int t = pwr( base, expon/2, modu ) ;
            return t*t % modu;
        }
        else
        {
            int t = pwr( base, expon-1, modu ) ;
            return base*t % modu ;
        }
    }

    public int cycle(int gen, int modu)
    {
        // Assume gen^i =1 % modul for some i>0
        int g = gen ;
        int i = 1 ;
        while ( g!=1 )
        {
            System.out.println(i + ": " + g) ;
            g = (g*gen)%modu ;
            i++ ;
        }
        System.out.println(i + ": " + g) ;
        return i ;
    }
}

