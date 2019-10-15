//
//  ViewController.swift
//  midterm
//
//  Created by Chris Vecchio on 10/15/19.
//  Copyright © 2019 Chris Vecchio. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var commuteText: UITextField!
    @IBOutlet weak var monthlySwitvh: UISwitch!
    @IBOutlet weak var tankSlider: UISlider!
    @IBOutlet weak var transitControl: UISegmentedControl!
    @IBOutlet weak var commuteLabel: UILabel!
    @IBOutlet weak var purchaseLabel: UILabel!
    @IBOutlet weak var gallonsLabel: UILabel!
    
    func updateCommuteTime(){
        var miles:Int
        let speed = 20
        if commuteText.text!.isEmpty{
            miles = 0
        } else {
            miles = Int(commuteText.text!)!
        }
        //let mpg = 24
        let time = miles/speed
        //self.updateCommuteTime()
        self.commuteLabel.text=String(format: "%.0f", time)
    }
    
    

    @IBAction func gasSliderAction(_ sender: UISlider) {
        let tankSlider = sender.value
        if (transitControl.selectedSegmentIndex == 0){
            commuteLabel.text! = String(format: "%.0f" ,time as! CVarArg)
        }
    }
    /*@IBAction func transitSegment(_ sender: UISegmentedControl) {
        if (transitControl.selectedSegmentIndex == 1){
            updateCommuteTime()
        }
    }
*/
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    }


