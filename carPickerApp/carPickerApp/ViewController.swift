//
//  ViewController.swift
//  carPickerApp
//
//  Created by Chris Vecchio on 10/1/19.
//  Copyright © 2019 Chris Vecchio. All rights reserved.
//

import UIKit
class Vehicle {
    var carMake : String?
    var carModel : String?
    var carPrice : Int?
}
class ViewController: UIViewController {
    @IBOutlet weak var changeCarType: UISegmentedControl!
    @IBOutlet weak var priceOutput: UILabel!
    @IBOutlet weak var mpgOutlet: UILabel!
    @IBOutlet weak var makeText: UILabel!
    @IBOutlet weak var modelText: UILabel!
    @IBOutlet weak var priceText: UILabel!
    @IBOutlet weak var mpgValue: UISlider!
    @IBOutlet weak var changeImage: UISegmentedControl!
    @IBAction func bodyStylePicker(_ sender: Any) {
    }
    @IBAction func carRandomizerButton(_ sender: Any) {
        if let url = URL(string: "https://www.audiusa.com/models") {
            UIApplication.shared.open(url)
        }
    }
    @IBOutlet weak var carImageArea: UIImageView!
    @IBAction func maxBudgetSlider(_ sender: UISlider) {
        let maxBudget = sender.value
        if (changeImage.selectedSegmentIndex == 0 && maxBudget < 34000 && mpgValue.value > 35 && mpgValue.value < 40){
            makeText.text = "Audi"
            modelText.text = "A3"
            priceText.text = "$33300"
            carImageArea.image = UIImage (named:"a3")
        }else if (changeImage.selectedSegmentIndex == 0 && maxBudget > 34001 && maxBudget < 38999 && mpgValue.value > 30 && mpgValue.value < 34){
            makeText.text = "Audi"
            modelText.text = "A4"
            priceText.text = "$37000"
            carImageArea.image = UIImage (named:"a4")
        }else if (changeImage.selectedSegmentIndex == 0 && maxBudget > 39000 && maxBudget < 45000 && mpgValue.value < 27){
            makeText.text = "Audi"
            modelText.text = "S4"
            priceText.text = "$44999"
            carImageArea.image = UIImage (named:"s4")
        }else if (changeImage.selectedSegmentIndex == 0 && maxBudget > 45001 && maxBudget < 50000 && mpgValue.value < 25 && mpgValue.value > 16){
            makeText.text = "Audi"
            modelText.text = "S5"
            priceText.text = "$49999"
            carImageArea.image = UIImage (named:"s5")
        }else if (changeImage.selectedSegmentIndex == 0 && maxBudget > 50001 && maxBudget < 70000){
            makeText.text = "Audi"
            modelText.text = "A7"
            priceText.text = "$65000"
            carImageArea.image = UIImage (named:"a7")
        }else if (changeImage.selectedSegmentIndex == 0 && maxBudget > 70001 && maxBudget < 90000){
            makeText.text = "Audi"
            modelText.text = "A8"
            priceText.text = "$74999"
            carImageArea.image = UIImage (named:"a8")
        }else if (changeImage.selectedSegmentIndex == 0 && maxBudget > 90001){
            makeText.text = "Audi"
            modelText.text = "R8"
            priceText.text = "$99000"
            carImageArea.image = UIImage (named:"r8")
        }else if (changeImage.selectedSegmentIndex == 1 && maxBudget < 34999 && mpgValue.value > 19 && mpgValue.value < 33){
            makeText.text = "Audi"
            modelText.text = "Q3"
            priceText.text = "$32000"
            carImageArea.image = UIImage (named:"q3")
        }else if (changeImage.selectedSegmentIndex == 1 && maxBudget > 35000 && maxBudget < 39999 && mpgValue.value > 19 && mpgValue.value < 33){
            makeText.text = "Audi"
            modelText.text = "Q5"
            priceText.text = "$37000"
            carImageArea.image = UIImage (named:"q5")
        }else if (changeImage.selectedSegmentIndex == 1 && maxBudget > 40001 && maxBudget < 49998 && mpgValue.value > 19 && mpgValue.value < 33){
            makeText.text = "Audi"
            modelText.text = "SQ5"
            priceText.text = "$49999"
            carImageArea.image = UIImage (named:"sq5")
        }else if (changeImage.selectedSegmentIndex == 1 && maxBudget > 49999 && maxBudget < 64999 && mpgValue.value > 19 && mpgValue.value < 33){
            makeText.text = "Audi"
            modelText.text = "Q7"
            priceText.text = "$69999"
            carImageArea.image = UIImage (named:"q7")
        }else if (changeImage.selectedSegmentIndex == 1 && maxBudget > 65000 && maxBudget < 74999 && mpgValue.value > 19 && mpgValue.value < 33){
            makeText.text = "Audi"
            modelText.text = "Q8"
            priceText.text = "$69999"
            carImageArea.image = UIImage (named:"q8")
        }else if (changeImage.selectedSegmentIndex == 1 && maxBudget > 75000 && maxBudget < 85000 && mpgValue.value > 49){
            makeText.text = "Audi"
            modelText.text = "E-Tron"
            priceText.text = "$84999"
            carImageArea.image = UIImage (named:"etron")
        }else if (changeImage.selectedSegmentIndex == 2){
            let alert = UIAlertController(title: "No vehicles available", message: "Please adjust your selection", preferredStyle: .alert)
            alert.addAction(UIAlertAction(title: "OK", style: .default, handler: nil))

            self.present(alert, animated: true)
        }
        priceOutput.text = String(format: "$%.0f", maxBudget)
    }
    @IBAction func minMPGSlider(_ sender: UISlider) {
        let minMPG = sender.value
        mpgOutlet.text = String(format: "%.0f" + " MPG", minMPG)
    }
    override func viewDidLoad() {
        super.viewDidLoad()

    }

}


