import axios from "axios";
import classNames from "classnames";
import jwt_decode from "jwt-decode";

//Using the array of objects that has the ratings from each product
//maps through each value to calculate an average value
export function calculateRating(arrayRatings) {
    if (arrayRatings !== undefined && isNaN(arrayRatings)) {
        let finalRating = 0;
        let amountRated = 0;
        //console.log(arrayRatings);
        arrayRatings.map((data) => {
            finalRating += data.valor;
            amountRated++;
        })
        /*console.log(finalRating);
        console.log(amountRated);*/
        return Math.round(finalRating / amountRated) * 2;
    } else {
        return "--"
    }
}

// Takes the star number amount and turns it into a string of star icons
export function createStarRatingString(star) {
    if (star) {
        //console.log(star)
        let singleStar = "★";
        let newStarRatingString = "";
        for (let i = 0; i <= star / 2 - 1; i++) {
            newStarRatingString += singleStar;
        }
        return newStarRatingString;
    } else {
        return ""
    }
}

//Takes a number from 1 to 10 and returns a word that defines what that number means
export function transformNumberRatingToTextEquivalent(number) {
    if (number) {
        switch (number) {
            case 1:
            case 2:
            case 3:
                return "Malo"
            case 4:
                return "Aceptable"
            case 5:
            case 6:
                return "Bueno"
            case 7:
            case 8:
                return "Muy bueno"
            case 9:
            case 10:
                return "Excelente"
            default:
                break;
        }
    } else {
        return ""
    }
}

//Will scroll the window to the coordinates (0, 0) 
export function scrollToTop() {
    window.scrollTo(0, 0)
}

//Goes through the array of objects that contains the images for each product
//and gets the first one
export function obtainASingleImageForCard(arrayObjects) {
    let singleImage = "";
    if (arrayObjects) {
        for (let i = 0; i < 1; i++) {
            if (arrayObjects[i]?.urlImg) {
                singleImage += arrayObjects[i].urlImg;
            }
        }
    } else {
        return singleImage;
    }
    return singleImage;
}

//Does an axios call to nominatim, an api that allows you to do reverse geocoding 
//(give a latitude and longitude and the api returns the actual adress of those coordinates if there is one)
export function getDirectionFromCoordinates(latitude, longitude, set, event) {
    const lat = latitude;
    const lng = longitude; //event.latlng;
    axios.get(`https://nominatim.openstreetmap.org/reverse?format=json&lat=${lat}&lon=${lng}`)
        .then((response) => {
            set(response.data.display_name);
        })
        .catch((error) => {
            console.log(error);
            set("Error fetching address");
        });
};


// Takes a string and makes it shorter, will also add a "más..." at the end if the string becomes shorter
export function textShortener(originalDescription, set, maxChar, classText, classMas, classBreak) {
    const longWordRegex = /\b\w{20,}\b/g;
    if (originalDescription) {
        let maxCharText = maxChar;
        /*if (screen.width === 414) {
            maxCharText = maxCharSmallScreen;
        }*/
        let newShortString = "";
        let masWord = "";
        for (let i = 0; i <= maxCharText; i++) {
            if (originalDescription[i] === undefined) {
                break;
            } else {
                newShortString += originalDescription[i];
            }
        }
        newShortString = newShortString.toLowerCase();
        newShortString = newShortString.charAt(0).toUpperCase() + newShortString.slice(1);
        //If the string is longer than maxCharText then '...' is added
        //at the end of the new shorter description
        if (originalDescription[maxCharText + 1] !== undefined) {
            newShortString += "...";
            masWord += " más...";
        }
        if (longWordRegex.test(originalDescription)) {
            const multipleClasses = classNames(classText, classBreak)
            set(
                <>
                    <span className={multipleClasses}>{newShortString}</span>
                    <span className={classMas}>{masWord}</span>
                </>
            );
        }
        else {
            set(
                <>
                    <span className={classText}>{newShortString}</span>
                    <span className={classMas}>{masWord}</span>
                </>
            );
        }
        //Sets the new modified shorter description inside a variable as jsx
    } else {
        return undefined;
    }
};


export function decodeToken(token, setDecoded) {
  if (token) {
    const decodedToken = jwt_decode(token);
    if (decodedToken && decodedToken.exp) {
      setDecoded(decodedToken);
    } else {
      console.error("Token is invalid or expired");
    }
  } else {
    console.error("Token is undefined");
  }
};

export function isTokenExpired(token) {
    if (!token) {
      return true;
    }
  
    const decodedToken = jwt_decode(token);
    if (!decodedToken.exp) {
      return true;
    }
  
    const now = Math.floor(Date.now() / 1000);
    return decodedToken.exp < now;
  }

  export function tokenLogOut() {
    localStorage.removeItem("jwt");
    localStorage.removeItem("Logged");
    window.postMessage({ type: "jwt", token: null }, "*");
    alert("Su sesión expiro")
  }

  export function descriptionFormat(description) {
    
    let newShortString;
    newShortString = description.toLowerCase();
    newShortString = newShortString.charAt(0).toUpperCase() + newShortString.slice(1);
    return newShortString; 
}

export function longWordsCheck(description) {
    const longWordRegex = /\b\w{20,}\b/g;
    if (longWordRegex.test(description)) {
        return true;
    } 
}




/*export function cutCategories(arrayCategories, cutNumber) {
    let newArray = []
    console.log(arrayCategories);
    for (let i = 0; i < cutNumber; i++) {
        //newArray.push(arrayCategories[i]);
        console.log(arrayCategories[i])
    }
    return newArray;
}*/